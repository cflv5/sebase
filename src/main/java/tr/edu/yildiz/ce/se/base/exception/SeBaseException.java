package tr.edu.yildiz.ce.se.base.exception;

import org.springframework.http.HttpStatus;

public class SeBaseException extends RuntimeException {
    private HttpStatus status;

    public SeBaseException() {
    }

    public SeBaseException(String message) {
        super(message);
    }

    public SeBaseException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

}
