package tw.com.firstbank.fcbcore.fir.service.application.in.customer.impl;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.CustomerService;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.GetCustomerResponseCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.GetCustomersRequestCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.GetCustomersResponseCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.GetCustomersUseCaseApi;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.mapper.CustomerUseCaseMapper;
import tw.com.firstbank.fcbcore.fir.service.domain.customer.type.StatusCode;

@Slf4j
@AllArgsConstructor
@Service
public class GetCustomersUseCaseImpl implements GetCustomersUseCaseApi {

  private CustomerUseCaseMapper mapper;

  private CustomerService service;

  @Override
  public GetCustomersResponseCommand execute(GetCustomersRequestCommand requestCommand) {
    GetCustomersResponseCommand resp = new GetCustomersResponseCommand();
    resp.setStatusCode(StatusCode.UNKNOWN_ERROR);

    try {
      List<GetCustomerResponseCommand> customers = new ArrayList<>();
      service.getAllCustomer()
          .forEach(customerDto -> customers.add(mapper.toGetCustomerResponseCommand(null, customerDto)));
      resp.setCustomers(customers);
      resp.setStatusCode(StatusCode.SUCCESS);

    } catch (Exception ex) {
      log.error("Get Customers Data Error.", ex);
    }

    return resp;
  }
}
