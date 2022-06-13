package tr.edu.yildiz.ce.se.base.service;

import static java.util.Map.entry;
import static tr.edu.yildiz.ce.se.base.domain.HeaderConstants.ACCESS_TOKEN;
import static tr.edu.yildiz.ce.se.base.domain.HeaderConstants.TENANT_ID;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import tr.edu.yildiz.ce.se.base.context.TenantContext;
import tr.edu.yildiz.ce.se.base.domain.ExceptionResponse;
import tr.edu.yildiz.ce.se.base.exception.SeBaseException;

@Service
public class StandartSeRestService implements SeRestService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StandartSeRestService.class);

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Value("${se.base.rest-client.access-token}")
    private String accessToken;

    @Autowired
    public StandartSeRestService(ObjectMapper objectMapper) {
        this.restTemplate = new RestTemplate();
        this.objectMapper = objectMapper;
    }

    @Override
    public <T, S> T call(String url, S payload, HttpMethod method, Class<T> clazz) {
        var headers = Map.ofEntries(
                entry(ACCESS_TOKEN, List.of(accessToken)),
                entry(TENANT_ID, List.of(TenantContext.getCurrentTenant().getTenantId())));
        try {
            HttpEntity<S> request = new HttpEntity<>(payload, CollectionUtils.toMultiValueMap(headers));
            var response = Optional.ofNullable(restTemplate.exchange(url, method, request, clazz).getBody());
            return response
                    .orElseThrow(
                            () -> new SeBaseException("Could not make a REST call", HttpStatus.INTERNAL_SERVER_ERROR));

        } catch (final HttpClientErrorException e) {
            var response = deserializeExceptionResponse(e);
            throw new SeBaseException(response.getResponseHeader().getMessage().getText(), e.getStatusCode());
        } catch (Exception e) {
            throwInternalError(e);
            return null;
        }

    }

    private ExceptionResponse deserializeExceptionResponse(HttpClientErrorException e) {
        try {
            LOGGER.error("Client returned with error:", e);
            return objectMapper.readValue(e.getResponseBodyAsString(), ExceptionResponse.class);
        } catch (Exception ex) {
            throwInternalError(ex);
            return null;
        }
    }

    private void throwInternalError(Exception e) {
        LOGGER.error("Exception occured while making rest call", e);
        throw new SeBaseException("Could not make a REST call", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
