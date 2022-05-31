package tr.edu.yildiz.ce.se.base.domain;

public class HeaderMessage {
    private final int code;
    private final String text;

    public HeaderMessage(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public static class Builder {
        private int code;
        private String text;

        public static Builder create() {
            return new Builder();
        }

        public Builder code(int code) {
            this.code = code;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public HeaderMessage build() {
            return new HeaderMessage(code, text);
        }

        public int getCode() {
            return code;
        }

        public String getText() {
            return text;
        }

    }

}
