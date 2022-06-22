package tr.edu.yildiz.ce.se.base.context;

public final class Tenant {
    private final String tenantId;
    private final String requestId;

    public Tenant(String tenantId, String requestId) {
        this.tenantId = tenantId;
        this.requestId = requestId;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public String getRequestId() {
        return requestId;
    }

}
