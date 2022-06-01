package tr.edu.yildiz.ce.se.base.advice;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import tr.edu.yildiz.ce.se.base.domain.ExceptionResponse;
import tr.edu.yildiz.ce.se.base.domain.HeaderMessage;
import tr.edu.yildiz.ce.se.base.domain.ResponseHeader;
import tr.edu.yildiz.ce.se.base.exception.SeBaseException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SeBaseException.class)
    public ResponseEntity<ExceptionResponse> handleBaseException(RuntimeException ex) {
        return ResponseEntity
                .internalServerError()
                .body(new ExceptionResponse(ResponseHeader
                        .fail(new HeaderMessage(500, ex.getMessage())), LocalDateTime.now()));
    }
}
