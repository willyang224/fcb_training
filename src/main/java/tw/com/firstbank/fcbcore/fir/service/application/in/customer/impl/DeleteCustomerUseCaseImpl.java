package tw.com.firstbank.fcbcore.fir.service.application.in.customer.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.CustomerService;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.DeleteCustomerRequestCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.DeleteCustomerResponseCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.DeleteCustomerUseCaseApi;
import tw.com.firstbank.fcbcore.fir.service.domain.customer.type.StatusCode;

@Slf4j
@AllArgsConstructor
@Service
public class DeleteCustomerUseCaseImpl implements DeleteCustomerUseCaseApi {

  private CustomerService service;

  @Override
  public DeleteCustomerResponseCommand execute(DeleteCustomerRequestCommand requestCommand) {
    DeleteCustomerResponseCommand resp = new DeleteCustomerResponseCommand();
    resp.setStatusCode(StatusCode.UNKNOWN_ERROR);

    try {
      service.deleteCustomer(requestCommand.getAccountNo());
      resp.setStatusCode(StatusCode.SUCCESS);
    } catch (Exception ex) {
      log.error("Delete Customer Error.", ex);
    }

    return resp;
  }
}
