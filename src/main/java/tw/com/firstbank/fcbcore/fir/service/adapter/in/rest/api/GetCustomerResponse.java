package tw.com.firstbank.fcbcore.fir.service.adapter.in.rest.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Date;
import lombok.Data;

@Data
public class GetCustomerResponse {
  @JsonInclude(Include.NON_NULL)
  private String statusCode;
  private String accountNo;
  private String name;
  private String type;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private Date birthday;
  private String email;

}
