package tw.com.firstbank.fcbcore.fir.service.adapter.in.rest.api;

import java.util.Date;
import lombok.Data;

@Data
public class UpdateCustomerRequest {
  private String name;
  private String type;
  private Date birthday;
  private String email;

}
