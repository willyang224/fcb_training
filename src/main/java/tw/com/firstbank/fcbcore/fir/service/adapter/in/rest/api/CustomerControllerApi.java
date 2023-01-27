package tw.com.firstbank.fcbcore.fir.service.adapter.in.rest.api;

import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1/customers")
@Validated
public interface CustomerControllerApi {

  /**
   * 取得所有顧客資訊
   * @return
   */
  GetCustomersResponse getCustomers();


  /**
   * 使用顧客編號取得顧客資訊
   * @param accountNo 顧客編號
   * @return
   */
  GetCustomerResponse getCustomer(final String accountNo);

  /**
   * 新增顧客
   * @param request 顧客資訊
   * @return
   */
  CreateCustomerResponse createCustomer(@Valid @RequestBody final CreateCustomerRequest request);

  /**
   * 修改顧客資訊
   * @param request 顧客資訊
   * @return
   */
  UpdateCustomerResponse updateCustomer(final String accountNo, @Valid @RequestBody final UpdateCustomerRequest request);

  /**
   * 使用顧客編號刪除顧客資訊
   * @param accountNo 顧客編號
   * @return
   */
  DeleteCustomerResponse deleteCustomer(final String accountNo);

}
