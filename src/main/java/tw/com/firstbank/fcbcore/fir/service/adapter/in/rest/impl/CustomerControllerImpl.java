package tw.com.firstbank.fcbcore.fir.service.adapter.in.rest.impl;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.com.firstbank.fcbcore.fir.service.adapter.in.rest.api.CreateCustomerRequest;
import tw.com.firstbank.fcbcore.fir.service.adapter.in.rest.api.CreateCustomerResponse;
import tw.com.firstbank.fcbcore.fir.service.adapter.in.rest.api.CustomerControllerApi;
import tw.com.firstbank.fcbcore.fir.service.adapter.in.rest.api.DeleteCustomerResponse;
import tw.com.firstbank.fcbcore.fir.service.adapter.in.rest.api.GetCustomerResponse;
import tw.com.firstbank.fcbcore.fir.service.adapter.in.rest.api.GetCustomersResponse;
import tw.com.firstbank.fcbcore.fir.service.adapter.in.rest.api.UpdateCustomerRequest;
import tw.com.firstbank.fcbcore.fir.service.adapter.in.rest.api.UpdateCustomerResponse;
import tw.com.firstbank.fcbcore.fir.service.adapter.in.rest.mapper.CustomerControllerMapper;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.CreateCustomerUseCaseApi;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.DeleteCustomerUseCaseApi;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.GetCustomerUseCaseApi;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.GetCustomersUseCaseApi;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.UpdateCustomerUseCaseApi;

@AllArgsConstructor
@RestController
public class CustomerControllerImpl implements CustomerControllerApi {

  private CustomerControllerMapper mapper;
  private GetCustomersUseCaseApi getAllCustomerApi;
  private GetCustomerUseCaseApi getCustomerApi;
  private CreateCustomerUseCaseApi createCustomerApi;
  private UpdateCustomerUseCaseApi updateCustomerApi;
  private DeleteCustomerUseCaseApi deleteCustomerApi;


  @Override
  @GetMapping("")
  public GetCustomersResponse getCustomers() {
    return mapper.toGetCustomersResponse(getAllCustomerApi.execute(null));
  }

  @Override
  @GetMapping("/{accountNo}")
  public GetCustomerResponse getCustomer(@PathVariable String accountNo) {
    return mapper.toGetCustomerResponse(getCustomerApi.execute(mapper.toGetCustomerRequestCommand(accountNo)));
  }

  @Override
  @PostMapping("")
  public CreateCustomerResponse createCustomer(CreateCustomerRequest request) {
    return mapper.toCreateCustomerResponse(createCustomerApi.execute(mapper.toCreateCustomerRequestCommand(request)));
  }

  @Override
  @PutMapping("/{accountNo}")
  public UpdateCustomerResponse updateCustomer(@PathVariable String accountNo, UpdateCustomerRequest request) {
    return mapper.toUpdateCustomerResponse(
        updateCustomerApi.execute(mapper.toUpdateCustomerRequestCommand(accountNo, request)));
  }

  @Override
  @DeleteMapping("/{accountNo}")
  public DeleteCustomerResponse deleteCustomer(@PathVariable String accountNo) {
    return mapper.toDeleteCustomerResponse(deleteCustomerApi.execute(mapper.toDeleteCustomerRequestCommand(accountNo)));
  }
}
