package tr.edu.yildiz.ce.se.base.domain;

import java.io.Serializable;

public final class RequestHeader implements Serializable {
    private String tenantId;

    public RequestHeader() {
        super();
    }

    public RequestHeader(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

}
