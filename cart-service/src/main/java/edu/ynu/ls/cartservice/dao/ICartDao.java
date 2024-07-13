package edu.ynu.ls.cartservice.dao;


import edu.ynu.ls.common.pojo.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICartDao extends JpaRepository<Cart,Integer> {
    List<Cart> findCartsByUserUserIdAndBusinessBusinessId(String userId, int businessId);
    Cart findCartsByUserUserIdAndBusinessBusinessIdAndFoodFoodId(String userId,int businessId,int foodId);
}
