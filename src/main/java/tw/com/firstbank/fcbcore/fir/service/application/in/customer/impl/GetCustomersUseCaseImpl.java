package tw.com.firstbank.fcbcore.fir.service.application.in.customer.impl;

import org.springframework.stereotype.Service;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.GetCustomersRequestCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.GetCustomersResponseCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.GetCustomersUseCaseApi;

@Service
public class GetCustomersUseCaseImpl implements GetCustomersUseCaseApi {

  @Override
  public GetCustomersResponseCommand execute(GetCustomersRequestCommand requestCommand) {
    return null;
  }
}
