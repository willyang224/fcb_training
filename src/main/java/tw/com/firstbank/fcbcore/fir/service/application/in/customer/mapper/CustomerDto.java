package tw.com.firstbank.fcbcore.fir.service.application.in.customer.mapper;

import java.util.Date;
import lombok.Data;

@Data
public class CustomerDto {

  private String accountNo;
  private String name;
  private String type;
  private Date birthday;
  private String email;

}
