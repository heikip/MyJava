package koolitus.REST;
import koolitus.REST.ErrorResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(MyException.class)
    public ResponseEntity<Object> handleMyExcpetion(MyException myException) {
        System.out.println("Exceptions to handle");
        //ErrorResponse ajutviga = new ErrorResponse(); //kui kasutada builder setterit, siis saab returnis anda objecti otse
        return new ResponseEntity<Object>(new ErrorResponse().setViga(myException.getMessage()), new HttpHeaders(), myException.getHttpStatus());
        // return new ResponseEntity<Object>(new ErrorResponse().setViga("message"), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleError(HttpStatus status, @Nullable String s6num) {
        System.out.println("Exceptions to handle");
        //ErrorResponse ajutviga = new ErrorResponse(); //kui kasutada builder setterit, siis saab returnis anda objecti otse
        return new ResponseEntity<Object>(new ErrorResponse().setViga(s6num), new HttpHeaders(), status);
       // return new ResponseEntity<Object>(new ErrorResponse().setViga("message"), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        System.out.println("piu piu. you feed me bad data");
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }
}

