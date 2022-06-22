package tr.edu.yildiz.ce.se.base.domain;

public final class HeaderConstants {

    private HeaderConstants() {
        throw new AssertionError("No instance allowed");
    }

    public static final String ACCESS_TOKEN = "X_SE_SERVICE_TOKEN";
    public static final String TENANT_ID = "X_TENANT_ID";
    public static final String REQUEST_ID = "X_REQUEST_ID";
}
