package tw.com.firstbank.fcbcore.fir.service.application.in.customer.api;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tw.com.firstbank.fcbcore.fir.service.application.in.core.RequestCommand;

@Setter
@Getter
@ToString
public class UpdateCustomerRequestCommand implements RequestCommand {

  private String accountNo;
  private String name;
  private String type;
  private Date birthday;
  private String email;

}
