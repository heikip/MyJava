package koolitus.REST;

import org.springframework.http.HttpStatus;

public class MyException extends RuntimeException {
    private HttpStatus httpStatus;
    public MyException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
