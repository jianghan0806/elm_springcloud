package edu.ynu.ls.deliveryaddressservice;

import edu.ynu.ls.common.pojo.DeliveryAddress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "deliveryaddress-service")  // 确保服务名称正确
public interface DeliveryAddressFeignClient {
    @GetMapping("/deliveryAddress/getDeliveryAddressByUserId")
    List<DeliveryAddress> getDeliveryAddressByUserId(@RequestParam(value = "userId") String userId);

    @GetMapping("/deliveryAddress/getDeliveryAddressByDaId")
    DeliveryAddress getDeliveryAddressByDaId(@RequestParam(value = "daId") int daId);

    @PostMapping("/deliveryAddress/saveDeliveryAddress")
    int saveDeliveryAddress(@RequestParam(value = "contactName") String contactName,
                            @RequestParam(value = "contactSex") int contactSex,
                            @RequestParam(value = "contactTel") String contactTel,
                            @RequestParam(value = "address") String address,
                            @RequestParam(value = "userId") String userId);

    @PostMapping("/deliveryAddress/updateDeliveryAddress")
    int updateDeliveryAddress(@RequestParam(value = "daId") int daId,
                              @RequestParam(value = "contactName") String contactName,
                              @RequestParam(value = "contactSex") int contactSex,
                              @RequestParam(value = "contactTel") String contactTel,
                              @RequestParam(value = "address") String address);

    @GetMapping("/deliveryAddress/removeDeliveryAddress")
    int removeDeliveryAddress(@RequestParam(value = "daId") int daId,
                              @RequestParam(value = "userId") String userId);
}
