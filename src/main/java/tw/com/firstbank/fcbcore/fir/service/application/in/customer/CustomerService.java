package tw.com.firstbank.fcbcore.fir.service.application.in.customer;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tw.com.firstbank.fcbcore.fir.service.adapter.out.repository.customer.api.CustomerRepository;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.mapper.CustomerDto;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.mapper.CustomerUseCaseMapper;
import tw.com.firstbank.fcbcore.fir.service.domain.customer.Customer;

@AllArgsConstructor
@Service
public class CustomerService {

  private CustomerUseCaseMapper mapper;

  private CustomerRepository customerRepo;

  public List<CustomerDto> getAllCustomer() {
    List<CustomerDto> result = new ArrayList<>();
    customerRepo.findAll().forEach(customer -> result.add(mapper.toDto(customer)));
    return result;
  }

  public CustomerDto getCustomer(String accountNo) {
    return mapper.toDto(customerRepo.findById(accountNo).orElse(null));
  }

  public CustomerDto createCustomer(CustomerDto dto) {
    return this.saveCustomer(dto);
  }

  public CustomerDto updateCustomer(CustomerDto dto) {
    if(customerRepo.findById(dto.getAccountNo()).isEmpty()) {
      throw new RuntimeException("No Customer Data.");
    }
    return this.saveCustomer(dto);
  }

  private CustomerDto saveCustomer(CustomerDto dto) {
    Customer entity = mapper.toEntity(dto);
    customerRepo.save(entity);
    return mapper.toDto(entity);
  }

  public void deleteCustomer(String accountNo) {
    customerRepo.deleteById(accountNo);
  }

}
