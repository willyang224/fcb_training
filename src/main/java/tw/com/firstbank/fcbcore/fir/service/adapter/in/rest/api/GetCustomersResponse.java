package tw.com.firstbank.fcbcore.fir.service.adapter.in.rest.api;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class GetCustomersResponse {

  List<GetCustomerResponse> customers = new ArrayList<>();

}
