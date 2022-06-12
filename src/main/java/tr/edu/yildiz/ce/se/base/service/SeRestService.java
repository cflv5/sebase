package tr.edu.yildiz.ce.se.base.service;

import org.springframework.http.HttpMethod;

public interface SeRestService {
    <T, S> T call(String url, S payload, HttpMethod method, Class<T> clazz);
}
