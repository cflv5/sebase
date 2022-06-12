package tr.edu.yildiz.ce.se.base.domain;

import java.io.Serializable;

public class HeaderMessage implements Serializable {
    private int code;
    private String text;

    public HeaderMessage() {
        super();
    }

    public HeaderMessage(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
