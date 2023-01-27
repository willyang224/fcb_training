package tw.com.firstbank.fcbcore.fir.service.adapter.in.rest.mapper;

import org.mapstruct.Mapper;
import tw.com.firstbank.fcbcore.fir.service.adapter.in.rest.api.CreateCustomerRequest;
import tw.com.firstbank.fcbcore.fir.service.adapter.in.rest.api.CreateCustomerResponse;
import tw.com.firstbank.fcbcore.fir.service.adapter.in.rest.api.DeleteCustomerResponse;
import tw.com.firstbank.fcbcore.fir.service.adapter.in.rest.api.GetCustomerResponse;
import tw.com.firstbank.fcbcore.fir.service.adapter.in.rest.api.GetCustomersResponse;
import tw.com.firstbank.fcbcore.fir.service.adapter.in.rest.api.UpdateCustomerRequest;
import tw.com.firstbank.fcbcore.fir.service.adapter.in.rest.api.UpdateCustomerResponse;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.CreateCustomerRequestCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.CreateCustomerResponseCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.DeleteCustomerRequestCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.DeleteCustomerResponseCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.GetCustomerRequestCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.GetCustomerResponseCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.GetCustomersResponseCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.UpdateCustomerRequestCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.UpdateCustomerResponseCommand;

@Mapper(componentModel = "spring")
public interface CustomerControllerMapper {

  GetCustomersResponse toGetCustomersResponse(GetCustomersResponseCommand source);
  GetCustomerRequestCommand toGetCustomerRequestCommand(String accountNo);
  GetCustomerResponse toGetCustomerResponse(GetCustomerResponseCommand source);
  DeleteCustomerRequestCommand toDeleteCustomerRequestCommand(String accountNo);
  DeleteCustomerResponse toDeleteCustomerResponse(DeleteCustomerResponseCommand source);
  CreateCustomerRequestCommand toCreateCustomerRequestCommand(CreateCustomerRequest source);
  CreateCustomerResponse toCreateCustomerResponse(CreateCustomerResponseCommand source);
  UpdateCustomerRequestCommand toUpdateCustomerRequestCommand(String accountNo, UpdateCustomerRequest source);
  UpdateCustomerResponse toUpdateCustomerResponse(UpdateCustomerResponseCommand source);
}
