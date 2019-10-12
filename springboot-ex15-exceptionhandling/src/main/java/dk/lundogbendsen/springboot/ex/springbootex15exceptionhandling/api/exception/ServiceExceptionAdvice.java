package dk.lundogbendsen.springboot.ex.springbootex15exceptionhandling.api.exception;

import dk.lundogbendsen.springboot.ex.springbootex15exceptionhandling.service.exception.NotFoundServiceException;
import dk.lundogbendsen.springboot.ex.springbootex15exceptionhandling.service.exception.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class ServiceExceptionAdvice {

    @ExceptionHandler({ServiceException.class})
    public ResponseEntity<Object> handleException(HttpServletRequest httpServletRequest, ServiceException se) {

        HttpStatus status = se instanceof NotFoundServiceException ? HttpStatus.NOT_FOUND : HttpStatus.BAD_REQUEST;

        ApiError apiError = ApiError.builder()
                .timestamp(new Date())
                .message(se.getMessage())
                .status(status.value())
                .error(status.getReasonPhrase())
                .path(httpServletRequest.getServletPath())
                .build();

        return new ResponseEntity<>(apiError, status);
    }


}
