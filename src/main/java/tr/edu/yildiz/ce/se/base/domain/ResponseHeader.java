package tr.edu.yildiz.ce.se.base.domain;

import java.io.Serializable;

public final class ResponseHeader implements Serializable {
    private boolean success;
    private HeaderMessage message;

    public ResponseHeader() {
        super();
    }

    public ResponseHeader(boolean success, HeaderMessage message) {
        this.success = success;
        this.message = message;
    }

    public static ResponseHeader success() {
        return new ResponseHeader(true, new HeaderMessage(0, ""));
    }

    public static ResponseHeader success(String text) {
        return new ResponseHeader(true, new HeaderMessage(0, text));
    }

    public static ResponseHeader fail(HeaderMessage message) {
        return new ResponseHeader(false, message);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public HeaderMessage getMessage() {
        return message;
    }

    public void setMessage(HeaderMessage message) {
        this.message = message;
    }

    public static class Builder {
        private boolean success;
        private HeaderMessage message;

        public static Builder create() {
            return new Builder();
        }

        public Builder success(boolean success) {
            this.success = success;
            return this;
        }

        public Builder message(HeaderMessage message) {
            this.message = message;
            return this;
        }

        public ResponseHeader build() {
            return new ResponseHeader(success, message);
        }
    }

}
