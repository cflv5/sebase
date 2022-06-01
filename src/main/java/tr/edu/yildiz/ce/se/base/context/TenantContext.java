package tr.edu.yildiz.ce.se.base.context;

public class TenantContext {
    private static ThreadLocal<Tenant> currentTenant = new InheritableThreadLocal<>();

    private TenantContext() {
        throw new IllegalStateException("No instance allowed!");
    }

    public static Tenant getCurrentTenant() {
        return currentTenant.get();
    }

    public static void setCurrentTenant(Tenant tenant) {
        currentTenant.set(tenant);
    }

    public static void clear() {
        currentTenant.remove();
    }
}
