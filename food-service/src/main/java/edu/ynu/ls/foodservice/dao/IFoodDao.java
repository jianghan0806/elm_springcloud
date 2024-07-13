package edu.ynu.ls.foodservice.dao;

import edu.ynu.ls.common.pojo.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFoodDao extends JpaRepository<Food, Integer> {
    List<Food> findFoodByBusinessBusinessId(int businessId);
    Food findFoodByFoodId(int foodId);
}
