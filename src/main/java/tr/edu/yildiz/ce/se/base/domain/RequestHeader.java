package tr.edu.yildiz.ce.se.base.domain;

import java.io.Serializable;

public final class RequestHeader implements Serializable {
    private final String tenantId;

    public RequestHeader(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantId() {
        return tenantId;
    }

}
