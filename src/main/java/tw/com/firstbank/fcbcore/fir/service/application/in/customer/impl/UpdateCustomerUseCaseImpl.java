package tw.com.firstbank.fcbcore.fir.service.application.in.customer.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.CustomerService;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.UpdateCustomerRequestCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.UpdateCustomerResponseCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.UpdateCustomerUseCaseApi;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.mapper.CustomerUseCaseMapper;
import tw.com.firstbank.fcbcore.fir.service.domain.customer.type.StatusCode;

@Slf4j
@AllArgsConstructor
@Service
public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCaseApi {

  private CustomerUseCaseMapper mapper;

  private CustomerService service;

  @Override
  public UpdateCustomerResponseCommand execute(UpdateCustomerRequestCommand requestCommand) {
    UpdateCustomerResponseCommand resp = new UpdateCustomerResponseCommand(StatusCode.UNKNOWN_ERROR);

    try {
      service.updateCustomer(mapper.toDto(requestCommand));
      resp.setAccountNo(requestCommand.getAccountNo());
      resp.setStatusCode(StatusCode.SUCCESS);
    } catch (Exception ex) {
      log.error("Update Customer Error.", ex);
    }

    return resp;
  }

}
