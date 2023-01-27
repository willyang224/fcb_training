package tw.com.firstbank.fcbcore.fir.service.adapter.out.repository.customer.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import tw.com.firstbank.fcbcore.fir.service.domain.customer.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>, JpaSpecificationExecutor<Customer> {

}
