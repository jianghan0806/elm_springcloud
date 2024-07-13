package edu.ynu.ls.foodservice.service;

import edu.ynu.ls.common.pojo.Food;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IFoodService {
    List<Food> getFoodByBusinessId(int businessId);
    Food getByFoodId( int foodId);
}
