package tw.com.firstbank.fcbcore.fir.service.application.in.customer.impl;

import org.springframework.stereotype.Service;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.CreateCustomerRequestCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.CreateCustomerResponseCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.CreateCustomerUseCaseApi;

@Service
public class CreateCustomerUseCaseImpl implements CreateCustomerUseCaseApi {

  @Override
  public CreateCustomerResponseCommand execute(CreateCustomerRequestCommand requestCommand) {
    return null;
  }

}
