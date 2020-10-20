package com.babyjuan.house.repository.es;

import com.babyjuan.house.common.condition.ElasticSearchCondition;
import com.babyjuan.house.common.utils.BeanUtils;
import com.babyjuan.house.common.utils.JsonUtils;
import com.babyjuan.house.repository.ESRepository;
import com.babyjuan.house.repository.es.entity.SecondHandHouseEO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.tuple.Pair;
import org.elasticsearch.action.DocWriteResponse.Result;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.replication.ReplicationResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Repository;

/**
 * @author anxi
 * @version 2020/9/2 19:32
 */
@Repository
@Conditional({ElasticSearchCondition.class})
public class ESRepositoryImpl implements ESRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ESRepositoryImpl.class);

    @Autowired
    private RestHighLevelClient client;

    @Override
    public Pair<Long, List<SecondHandHouseEO>> getSecondHouseList(int offset, int limit) {
        SearchRequest request = new SearchRequest("second_hand_house");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.from(offset);
        sourceBuilder.size(limit);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        request.source(sourceBuilder);

        try {
            SearchResponse searchResponse = client.search(request, RequestOptions.DEFAULT);
            System.out.println(JsonUtils.objectToJson(searchResponse));
            List<SecondHandHouseEO> list = new ArrayList<>();
            for (SearchHit hit : searchResponse.getHits()) {
                Map<String, Object> map = hit.getSourceAsMap();
                list.add(BeanUtils.mapToObject(map, SecondHandHouseEO.class));
            }
            return Pair.of((long) list.size(), list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Pair.of(-1L, new ArrayList<>());
    }

    @Override
    public Pair<Long, List<SecondHandHouseEO>> getSecondHouseList(int offset, int limit, String title) {
        SearchRequest request = new SearchRequest("second_hand_house");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.from(offset);
        sourceBuilder.size(limit);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        MatchQueryBuilder queryBuilder = new MatchQueryBuilder("title", title);
        sourceBuilder.query(queryBuilder);
        request.source(sourceBuilder);

        try {
            SearchResponse searchResponse = client.search(request, RequestOptions.DEFAULT);
            System.out.println(JsonUtils.objectToJson(searchResponse));
            List<SecondHandHouseEO> list = new ArrayList<>();
            for (SearchHit hit : searchResponse.getHits()) {
                Map<String, Object> map = hit.getSourceAsMap();
                list.add(BeanUtils.mapToObject(map, SecondHandHouseEO.class));
            }
            return Pair.of((long) list.size(), list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Pair.of(-1L, new ArrayList<>());
    }

    @Override
    public boolean putSecondHouse(SecondHandHouseEO secondHandHouseEO) {
        Map<String, Object> map = BeanUtils.objectToMap(secondHandHouseEO);
        IndexRequest request = new IndexRequest("second_hand_house", "_doc", secondHandHouseEO.getHouseCode())
                .source(map);
        request.routing(secondHandHouseEO.getHouseCode());
        try {
            IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
            if (indexResponse.getResult() == Result.CREATED || indexResponse.getResult() == Result.UPDATED) {
                return true;
            }
            ReplicationResponse.ShardInfo shardInfo = indexResponse.getShardInfo();
            if (shardInfo.getFailed() > 0) {
                for (ReplicationResponse.ShardInfo.Failure failure : shardInfo.getFailures()) {
                    String reason = failure.reason();
                    LOGGER.error("put es error, {}", reason);
                }
                return false;
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("put es error.", e);
        }
        return false;
    }

    @Override
    public boolean deleteSecondHouse(String houseCode) {
        DeleteRequest request = new DeleteRequest("second_hand_house", "_doc", houseCode);
        request.routing(houseCode);
        try {
            DeleteResponse deleteResponse = client.delete(request, RequestOptions.DEFAULT);
            ReplicationResponse.ShardInfo shardInfo = deleteResponse.getShardInfo();
            if (shardInfo.getFailed() > 0) {
                for (ReplicationResponse.ShardInfo.Failure failure : shardInfo.getFailures()) {
                    String reason = failure.reason();
                    LOGGER.error("delete es error, {}", reason);
                }
                return false;
            }
            return true;
        } catch (IOException e) {
            LOGGER.error("delete es error", e);
        }
        return false;
    }
}
