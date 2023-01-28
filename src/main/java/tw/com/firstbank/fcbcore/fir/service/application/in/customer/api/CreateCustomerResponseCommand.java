package tw.com.firstbank.fcbcore.fir.service.application.in.customer.api;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tw.com.firstbank.fcbcore.fir.service.application.in.core.ResponseCommand;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class CreateCustomerResponseCommand implements ResponseCommand {

  @NonNull
  private String statusCode;
  private String accountNo;

}
