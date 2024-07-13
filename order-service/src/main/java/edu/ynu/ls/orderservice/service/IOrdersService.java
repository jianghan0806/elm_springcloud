package edu.ynu.ls.orderservice.service;

import edu.ynu.ls.common.pojo.Orders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public interface IOrdersService {
    int createOrders(String userId,int businessId,int daId,Double orderTotal);
    Orders getOrdersByOrdersId(int orderId);
    List<Orders> getOrdersByUserId(String userId);
    int updateOrderState( int orderId);
}
