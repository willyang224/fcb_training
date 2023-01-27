package tw.com.firstbank.fcbcore.fir.service.adapter.in.rest.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestApiResponse {

  private String errorCode;

  private Object data;

}
