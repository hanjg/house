package com.babyjuan.house.common.config;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import java.util.Properties;
import java.util.concurrent.Executor;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author anxi
 * @version 2020/9/10 19:44
 */
public abstract class BaseNacoConfig {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${spring.cloud.nacos.config.server-addr}")
    private String serverAddr;

    @Value("${spring.cloud.nacos.config.namespace}")
    private String namespace;

    @Value("${spring.cloud.nacos.config.group}")
    private String group;

    private ConfigService configService;

    @PostConstruct
    public void init() throws Exception {
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
        properties.put(PropertyKeyConst.NAMESPACE, namespace);
        configService = NacosFactory.createConfigService(properties);

        initContent(fetchContent());

        configService.addListener(dataId(), group, new Listener() {
            @Override
            public void receiveConfigInfo(String configInfo) {
                try {
                    changeContent(fetchContent());
                } catch (NacosException e) {
                    logger.error("{} change error.", dataId());
                }
            }

            @Override
            public Executor getExecutor() {
                return null;
            }
        });
    }

    private String fetchContent() throws NacosException {
        String content = configService.getConfig(dataId(), group, 5000);
        logger.info("fetch data, dataId: {}, content: {}", dataId(), content);
        return content;
    }

    public abstract String dataId();

    public abstract void initContent(String content);

    public abstract void changeContent(String content);

}
