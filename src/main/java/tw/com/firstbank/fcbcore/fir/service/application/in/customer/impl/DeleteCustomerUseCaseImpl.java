package tw.com.firstbank.fcbcore.fir.service.application.in.customer.impl;

import org.springframework.stereotype.Service;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.DeleteCustomerRequestCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.DeleteCustomerResponseCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.DeleteCustomerUseCaseApi;

@Service
public class DeleteCustomerUseCaseImpl implements DeleteCustomerUseCaseApi {

  @Override
  public DeleteCustomerResponseCommand execute(DeleteCustomerRequestCommand requestCommand) {
    return null;
  }
}
