package edu.ynu.ls.orderservice.impl;


import edu.ynu.ls.businessservice.dao.IBusinessDao;
import edu.ynu.ls.cartservice.dao.ICartDao;
import edu.ynu.ls.common.pojo.*;
import edu.ynu.ls.deliveryaddressservice.dao.IDeliveryAddressDao;
import edu.ynu.ls.orderservice.dao.IOrdersDao;
import edu.ynu.ls.orderservice.service.IOrdersService;
import edu.ynu.ls.userservice.dao.IUserDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
public class OrdersServiceImpl implements IOrdersService {
    @Resource
    IOrdersDao iOrdersDao;
    @Resource
    IUserDao iUserDao;
    @Resource
    IBusinessDao iBusinessDao;
    @Resource
    IDeliveryAddressDao iDeliveryAddressDao;
    @Resource
    ICartDao iCartDao;
    @Override
    @Transactional
    public int createOrders(String userId,int businessId,int daId,Double orderTotal) {
        Orders orders = new Orders();
        orders.setOrderTotal(orderTotal);
        User user = iUserDao.findUserByUserId(userId);
        Business business = iBusinessDao.findBusinessByBusinessId(businessId);
        orders.setBusiness(business);
        DeliveryAddress deliveryAddress = iDeliveryAddressDao.findDeliveryAddressByDaId(daId);
        orders.setDeliveryAddress(deliveryAddress);
        user.addOrders(orders);

        List<Cart> carts = iCartDao.findCartsByUserUserIdAndBusinessBusinessId(userId,businessId);
        for (Cart cart: carts){
            OrderDetailet orderDetailet = new OrderDetailet();
            orderDetailet.setFood(cart.getFood());
            orderDetailet.setQuantity(cart.getQuantity());
            orders.addOrderDetail(orderDetailet);
            user.removeCarts(cart);
        }
        iUserDao.save(user);
        System.out.println(orders.getOrderId());
        return orders.getOrderId();
    }
    @Override
    public Orders getOrdersByOrdersId(int orderId){
        Orders orders = iOrdersDao.findOrdersByOrderId(orderId);
        System.out.println(orders.getOrderId());
        return orders;
    }
    @Override
    public List<Orders> getOrdersByUserId(String userId){
        return iOrdersDao.findOrdersByUserUserId(userId);
    }
    @Override
    public int updateOrderState( int orderId){
        Orders orders = iOrdersDao.findOrdersByOrderId(orderId);
        orders.setOrderState(1);
        iOrdersDao.save(orders);
        return orders.getOrderState();
    }
}
