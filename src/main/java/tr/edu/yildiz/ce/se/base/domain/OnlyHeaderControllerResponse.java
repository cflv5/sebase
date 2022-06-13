package tr.edu.yildiz.ce.se.base.domain;

import java.io.Serializable;

public class OnlyHeaderControllerResponse implements Serializable {
    private final ResponseHeader responseHeader;

    public OnlyHeaderControllerResponse(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public static OnlyHeaderControllerResponse success() {
        return new OnlyHeaderControllerResponse(ResponseHeader.success());
    }

    public static OnlyHeaderControllerResponse success(String text) {
        return new OnlyHeaderControllerResponse(ResponseHeader.success(text));
    }

    public static OnlyHeaderControllerResponse failed(HeaderMessage message) {
        return new OnlyHeaderControllerResponse(ResponseHeader.fail(message));
    }

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

}
