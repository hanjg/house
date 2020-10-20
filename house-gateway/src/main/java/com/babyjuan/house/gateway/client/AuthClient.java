package com.babyjuan.house.gateway.client;

import java.net.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author anxi
 * @version 2020/9/27 13:18
 */
@Component
public class AuthClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthClient.class);

    private RestTemplate restTemplate = new RestTemplate();

    @Value("#{'${service.url.oauth}'+'/oauth/check_token'}")
    private String checkTokenUrl;

    public boolean hasPermissionControl(String url) {
        return url.startsWith("/house");
    }

    public boolean accessable(ServerHttpRequest request) {
        String token = request.getQueryParams().getFirst("token");
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(checkTokenUrl).queryParam("token", token);
        URI url = builder.build().encode().toUri();

        HttpEntity<?> entity = new HttpEntity<>(request.getHeaders());

        try {
            ResponseEntity<TokenInfo> response = restTemplate.exchange(url, HttpMethod.GET, entity, TokenInfo.class);
            LOGGER.info("oauth request: {}, response body: {}, reponse status: {}",
                    entity, response.getBody(), response.getStatusCode());
            return response.getBody() != null && response.getBody().isActive();
        } catch (RestClientException e) {
            LOGGER.error("oauth failed.", e);
        }
        return false;
    }
}
