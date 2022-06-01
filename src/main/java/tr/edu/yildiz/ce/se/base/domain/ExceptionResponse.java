package tr.edu.yildiz.ce.se.base.domain;

import java.time.LocalDateTime;

public class ExceptionResponse {
    private ResponseHeader responseHeader;
    private LocalDateTime time;

    public ExceptionResponse() {
    }

    public ExceptionResponse(ResponseHeader responseHeader, LocalDateTime time) {
        this.responseHeader = responseHeader;
        this.time = time;
    }

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

}
