package tw.com.firstbank.fcbcore.fir.service.application.in.customer.impl;

import org.springframework.stereotype.Service;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.UpdateCustomerRequestCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.UpdateCustomerResponseCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.UpdateCustomerUseCaseApi;

@Service
public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCaseApi {

  @Override
  public UpdateCustomerResponseCommand execute(UpdateCustomerRequestCommand requestCommand) {
    return null;
  }
}
