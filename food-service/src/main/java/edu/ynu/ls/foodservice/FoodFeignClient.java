package edu.ynu.ls.foodservice;

import edu.ynu.ls.common.pojo.Food;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "Provider")
public interface FoodFeignClient {
    @GetMapping("/food/getFoodByBusinessId")
    List<Food> getFoodByBusinessId(@RequestParam(value = "businessId") int businessId);

    @GetMapping("/food/getByFoodId")
    Food getByFoodId(@RequestParam(value = "fooId") int fooId);
}
