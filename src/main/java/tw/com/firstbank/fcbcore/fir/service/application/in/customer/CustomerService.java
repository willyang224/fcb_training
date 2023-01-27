package tw.com.firstbank.fcbcore.fir.service.application.in.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tw.com.firstbank.fcbcore.fir.service.adapter.out.repository.customer.api.CustomerRepository;

@AllArgsConstructor
@Service
public class CustomerService {

  private CustomerRepository customerRepo;

}
