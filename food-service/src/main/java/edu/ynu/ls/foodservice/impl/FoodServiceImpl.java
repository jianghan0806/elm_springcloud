package edu.ynu.ls.foodservice.impl;

import edu.ynu.ls.common.pojo.Food;
import edu.ynu.ls.foodservice.dao.IFoodDao;
import edu.ynu.ls.foodservice.service.IFoodService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements IFoodService {
    @Resource
    IFoodDao iFoodDao;

    @Override
    public List<Food> getFoodByBusinessId(int businessId){
        return iFoodDao.findFoodByBusinessBusinessId(businessId);
    }

    @Override
    public Food getByFoodId(int foodId){
        return iFoodDao.findFoodByFoodId(foodId);
    }
}

