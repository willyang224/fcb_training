package tw.com.firstbank.fcbcore.fir.service.application.in.customer.api;

import java.util.Date;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tw.com.firstbank.fcbcore.fir.service.application.in.core.ResponseCommand;

@Setter
@Getter
@ToString
public class GetCustomerResponseCommand implements ResponseCommand {

  private String statusCode;
  private String accountNo;
  private String name;
  private String type;
  private Date birthday;
  private String email;

}
