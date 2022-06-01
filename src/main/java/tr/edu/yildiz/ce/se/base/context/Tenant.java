package tr.edu.yildiz.ce.se.base.context;

public final class Tenant {
    private final String tenantId;

    Tenant(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantId() {
        return this.tenantId;
    }
}
