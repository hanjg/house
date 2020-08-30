package com.babyjuan.house.repository.es.config;

import com.babyjuan.house.common.condition.DevCondition;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author anxi
 * @version 2020/8/19 10:54
 */
@Configuration
@Conditional({DevCondition.class})
public class ESConfig {

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
        return client;
    }
}
