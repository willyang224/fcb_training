package tw.com.firstbank.fcbcore.fir.service.domain.exception;

import java.io.Serial;

public class FCBRuntimeException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = 1200807993542989236L;


  public FCBRuntimeException(String message) {
    super(message);
  }
}
