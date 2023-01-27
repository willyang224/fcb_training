package tw.com.firstbank.fcbcore.fir.service.application.in.customer.impl;

import org.springframework.stereotype.Service;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.GetCustomerRequestCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.GetCustomerResponseCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.GetCustomerUseCaseApi;

@Service
public class GetCustomerUseCaseImpl implements GetCustomerUseCaseApi {

  @Override
  public GetCustomerResponseCommand execute(GetCustomerRequestCommand requestCommand) {
    return null;
  }
}
