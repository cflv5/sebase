package tr.edu.yildiz.ce.se.base.service;

import static java.util.Map.entry;
import static tr.edu.yildiz.ce.se.base.domain.HeaderConstants.ACCESS_TOKEN;
import static tr.edu.yildiz.ce.se.base.domain.HeaderConstants.TENANT_ID;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;

import tr.edu.yildiz.ce.se.base.context.TenantContext;
import tr.edu.yildiz.ce.se.base.exception.SeBaseException;

@Service
public class StandartSeRestService implements SeRestService {
    private final RestTemplate restTemplate;

    @Value("${se.base.rest-client.access-token}")
    private String accessToken;

    public StandartSeRestService() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public <T, S> T call(String url, S payload, HttpMethod method, Class<T> clazz) throws JsonProcessingException {
        var headers = Map.ofEntries(
                entry(ACCESS_TOKEN, List.of(accessToken)),
                entry(TENANT_ID, List.of(TenantContext.getCurrentTenant().getTenantId())));

        HttpEntity<S> request = new HttpEntity<>(payload, CollectionUtils.toMultiValueMap(headers));

        var response = Optional.ofNullable(restTemplate.exchange(url, method, request, clazz).getBody());

        return response
                .orElseThrow(() -> new SeBaseException("Could not make a REST call", HttpStatus.INTERNAL_SERVER_ERROR));
    }

}
