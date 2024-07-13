package edu.ynu.ls.orderdetailetservice.controller;

import edu.ynu.ls.common.pojo.OrderDetailet;
import edu.ynu.ls.orderdetailetservice.OrderDetailetFeignClient;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/orderDetailet")
public class OrderDetailetController {
    @Resource
    OrderDetailetFeignClient orderDetailetFeignClient;

    @GetMapping("/getByOrderId")
    public List<OrderDetailet> getByOrderId(@RequestParam int orderId) {
        return orderDetailetFeignClient.getByOrderId(orderId);
    }

    @PostMapping("/saveOrderDetailetBatch")
    public int saveOrderDetailetBatch(@RequestBody List<OrderDetailet> list) {
        return orderDetailetFeignClient.saveOrderDetailetBatch(list);
    }
}