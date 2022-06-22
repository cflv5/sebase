package tr.edu.yildiz.ce.se.base.context;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public final class TenantFactory {

    private static Map<String, Tenant> cache = new ConcurrentHashMap<>();

    private TenantFactory() {
        throw new IllegalStateException("No instance allowed!");
    }

    public static synchronized Tenant createTenant(String tenantId, String requestId) {
        var tenant = cache.get(tenantId);

        if (Objects.isNull(tenant)) {
            tenant = new Tenant(tenantId, requestId);
            cache.put(tenantId, tenant);
        }

        return tenant;
    }

}
