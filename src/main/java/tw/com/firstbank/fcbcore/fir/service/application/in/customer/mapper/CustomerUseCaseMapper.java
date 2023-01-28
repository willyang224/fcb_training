package tw.com.firstbank.fcbcore.fir.service.application.in.customer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.CreateCustomerRequestCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.GetCustomerResponseCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.UpdateCustomerRequestCommand;
import tw.com.firstbank.fcbcore.fir.service.domain.customer.Customer;

@Mapper(componentModel = "spring")
public interface CustomerUseCaseMapper {

  Customer toEntity(CustomerDto dto);

  CustomerDto toDto(Customer entity);

  @Mappings({
      @Mapping(source = "accountNo", target = "accountNo"),
      @Mapping(source = "command.name", target = "name"),
      @Mapping(source = "command.type", target = "type"),
      @Mapping(source = "command.email", target = "email"),
      @Mapping(source = "command.birthday", target = "birthday")
  })
  CustomerDto toDto(String accountNo, CreateCustomerRequestCommand command);


  CustomerDto toDto(UpdateCustomerRequestCommand command);

  @Mappings({
      @Mapping(source = "statusCode", target = "statusCode"),
      @Mapping(source = "dto.accountNo", target = "accountNo"),
      @Mapping(source = "dto.name", target = "name"),
      @Mapping(source = "dto.type", target = "type"),
      @Mapping(source = "dto.email", target = "email"),
      @Mapping(source = "dto.birthday", target = "birthday")
  })
  GetCustomerResponseCommand toGetCustomerResponseCommand(String statusCode, CustomerDto dto);

}
