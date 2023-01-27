package tw.com.firstbank.fcbcore.fir.service.domain.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;
import lombok.Data;

@Entity
@Data
public class Customer {

  @Id
  private String accountNo;
  private String name;
  private String type;
  private Date birthday;
  private String email;

}
