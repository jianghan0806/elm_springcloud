package edu.ynu.ls.orderdetailetservice;

import edu.ynu.ls.common.pojo.OrderDetailet;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "order-detailet-service", contextId = "orderDetailetFeignClient")
@LoadBalancerClient
public interface OrderDetailetFeignClient {

    @PostMapping("/orderDetailet/createOrderDetailet")
    int createOrderDetailet(@RequestParam("orderId") int orderId,
                            @RequestParam("productId") int productId,
                            @RequestParam("quantity") int quantity,
                            @RequestParam("price") double price);

    @GetMapping("/orderDetailet/getByOrderId")
    List<OrderDetailet> getByOrderId(@RequestParam("orderId") int orderId);

    @PostMapping("/orderDetailet/saveOrderDetailetBatch")
    int saveOrderDetailetBatch(@RequestBody List<OrderDetailet> orderDetailets);
}