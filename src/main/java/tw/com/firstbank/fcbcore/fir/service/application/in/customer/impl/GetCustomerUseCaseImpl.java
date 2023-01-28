package tw.com.firstbank.fcbcore.fir.service.application.in.customer.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.CustomerService;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.GetCustomerRequestCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.GetCustomerResponseCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.GetCustomerUseCaseApi;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.mapper.CustomerUseCaseMapper;
import tw.com.firstbank.fcbcore.fir.service.domain.customer.type.StatusCode;

@Slf4j
@AllArgsConstructor
@Service
public class GetCustomerUseCaseImpl implements GetCustomerUseCaseApi {

  private CustomerUseCaseMapper mapper;

  private CustomerService service;

  @Override
  public GetCustomerResponseCommand execute(GetCustomerRequestCommand requestCommand) {
    GetCustomerResponseCommand resp = new GetCustomerResponseCommand();
    resp.setStatusCode(StatusCode.UNKNOWN_ERROR);

    try {
      resp = mapper.toGetCustomerResponseCommand(StatusCode.SUCCESS,
          service.getCustomer(requestCommand.getAccountNo()));
    } catch (Exception ex) {
      log.error("Get Customer Data Error.", ex);
    }

    return resp;
  }
}
