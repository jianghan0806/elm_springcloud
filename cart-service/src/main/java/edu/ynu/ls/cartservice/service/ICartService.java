package edu.ynu.ls.cartservice.service;


import edu.ynu.ls.common.pojo.Cart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICartService {
    List<Cart> getCartAll(String userId, int businessId);
    int insertFoodIntoCart(String userId,int businessId, int foodId);
    int deleteCart(String userId, int businessId, int foodId);
    int updateCart(String userId, int businessId, int foodId, int quantity);
}