package tw.com.firstbank.fcbcore.fir.service.adapter.in.rest.api;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.Getter;

@Data
public class GetCustomersResponse {

  private String statusCode;

  List<GetCustomerResponse> customers = new ArrayList<>();

}
