package tr.edu.yildiz.ce.se.base.domain;

public final class RequestHeader {
    private final String tenantId;

    public RequestHeader(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantId() {
        return tenantId;
    }

}
