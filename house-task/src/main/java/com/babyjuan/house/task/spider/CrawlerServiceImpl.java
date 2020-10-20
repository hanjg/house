package com.babyjuan.house.task.spider;

import com.alibaba.dubbo.config.annotation.Service;
import com.babyjuan.house.contract.dto.BaseResponse;
import com.babyjuan.house.contract.dto.SpiderStateDTO;
import com.babyjuan.house.contract.service.CrawlerService;
import com.babyjuan.house.task.spider.command.CrawlerCommand;
import com.babyjuan.house.task.spider.webmagic.SpiderState;
import javax.annotation.Resource;

/**
 * @author anxi
 * @version 2020/9/4 19:54
 */
@Service
public class CrawlerServiceImpl implements CrawlerService {

    @Resource(name = "secondHandCrawlerCommandImpl")
    private CrawlerCommand secondHandCrawlerCommand;

    @Override
    public BaseResponse<SpiderStateDTO> secondHandHouseCrawlerStatus() {
        SpiderState spiderState = secondHandCrawlerCommand.status();
        SpiderStateDTO spiderStateDTO = new SpiderStateDTO();
        spiderStateDTO.setDuration(spiderState.getDuration());
        spiderStateDTO.setMillSecondsPerPage(spiderState.getMillSecondsPerPage());
        spiderStateDTO.setPageCount(spiderState.getPageCount());
        spiderStateDTO.setStartTime(spiderState.getStartTime());
        spiderStateDTO.setStatus(spiderState.getStatus().name());
        spiderStateDTO.setThreadAlive(spiderState.getThreadAlive());
        return BaseResponse.newSuccessResponse(spiderStateDTO);
    }


}
