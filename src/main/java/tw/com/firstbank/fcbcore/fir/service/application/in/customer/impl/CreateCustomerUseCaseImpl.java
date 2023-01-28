package tw.com.firstbank.fcbcore.fir.service.application.in.customer.impl;

import java.util.Random;
import java.util.stream.IntStream;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.CustomerService;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.CreateCustomerRequestCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.CreateCustomerResponseCommand;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.api.CreateCustomerUseCaseApi;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.mapper.CustomerDto;
import tw.com.firstbank.fcbcore.fir.service.application.in.customer.mapper.CustomerUseCaseMapper;
import tw.com.firstbank.fcbcore.fir.service.domain.customer.type.StatusCode;

@Slf4j
@AllArgsConstructor
@Service
public class CreateCustomerUseCaseImpl implements CreateCustomerUseCaseApi {

  private CustomerUseCaseMapper mapper;

  private CustomerService service;

  @Override
  public CreateCustomerResponseCommand execute(CreateCustomerRequestCommand requestCommand) {
    CreateCustomerResponseCommand resp = new CreateCustomerResponseCommand(StatusCode.UNKNOWN_ERROR);
    try {
      CustomerDto dto = service.createCustomer(mapper.toDto(getFakeAccountNo(), requestCommand));
      resp.setAccountNo(dto.getAccountNo());
      resp.setStatusCode(StatusCode.SUCCESS);
    } catch(Exception ex) {
      log.error("Create Customer Error.", ex);
    }
    return resp;
  }


  /**
   * 建立假的 accountNo
   * @return accountNo
   */
  private String getFakeAccountNo() {
    Random rand = new Random();
    // 分行代碼從 090 - 300
    int branchCode = rand.nextInt(90, 301);
    // 業務別代碼 2 碼
    int businessCategory = rand.nextInt(100);
    // 5 碼編號
    int serialNumber = rand.nextInt(100000);
    // 最後 1 碼為驗證碼
    int verificationCode = rand.nextInt(10);

    return String.format("%03d%02d%05d%d", branchCode, businessCategory, serialNumber, verificationCode);
  }
}
