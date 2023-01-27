package tw.com.firstbank.fcbcore.fir.service.adapter.in.rest.exception;

import tw.com.firstbank.fcbcore.fir.service.domain.exception.FCBRuntimeException;
import jakarta.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Tabris Chang
 * @description 共用 Rest Exception Handler
 * @since 3.0.0
 */
@ControllerAdvice
@RestController
public class RestApiExceptionHandler extends ResponseEntityExceptionHandler {

  private static final Logger logger = LoggerFactory.getLogger(RestApiExceptionHandler.class);

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<RestApiResponse> handleAllExceptions(Exception ex, WebRequest request) {

    String errorCode = "error-000";

    if (ex instanceof FCBRuntimeException) {
      errorCode = ex.getMessage();
    } else if (ex instanceof ConstraintViolationException) {
      errorCode = ex.getMessage();
    }

    logger.error(errorCode, ex);

    return new ResponseEntity<>(new RestApiResponse(errorCode, ExceptionUtils.getStackTrace(ex)),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });
    return new ResponseEntity<>(new RestApiResponse("", errors),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
