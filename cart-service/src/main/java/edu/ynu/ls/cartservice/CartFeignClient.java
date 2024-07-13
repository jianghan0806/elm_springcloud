package edu.ynu.ls.cartservice;

import edu.ynu.ls.common.pojo.Cart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "Provider")
public interface CartFeignClient {
    @PostMapping("/cart/getCartAll")
    List<Cart> getCartAll(@RequestParam(value = "userId") String userId, @RequestParam(value = "businessId") int businessId);

    @PostMapping("/cart/insertFoodIntoCart")
    int insertFoodIntoCart(@RequestParam(value = "userId") String userId, @RequestParam(value = "businessId") int businessId, @RequestParam(value = "foodId") int foodId);

    @PostMapping("/cart/deleteCart")
    int deleteCart(@RequestParam(value = "userId") String userId, @RequestParam(value = "businessId") int businessId, @RequestParam(value = "foodId") int foodId);

    @PostMapping("/cart/updateCart")
    int updateCart(@RequestParam(value = "userId") String userId, @RequestParam(value = "businessId") int businessId, @RequestParam(value = "foodId") int foodId, @RequestParam(value = "quantity") int quantity);
}
