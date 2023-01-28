package tw.com.firstbank.fcbcore.fir.service.application.in.customer.api;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tw.com.firstbank.fcbcore.fir.service.application.in.core.ResponseCommand;

@Setter
@Getter
@ToString
public class GetCustomersResponseCommand implements ResponseCommand {

  private String statusCode;

  List<GetCustomerResponseCommand> customers;

}
