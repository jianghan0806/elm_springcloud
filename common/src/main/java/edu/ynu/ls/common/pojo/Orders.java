package edu.ynu.ls.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="userId",referencedColumnName = "userId",nullable = false)
    private User user;
    @JoinColumn(
            name = "businessId",
            referencedColumnName = "businessId",
            nullable = false
    )
    @ManyToOne
    private Business business;
    private String orderDate;
    private Double orderTotal;
    @ManyToOne
    @JoinColumn(
            name = "daId",
            referencedColumnName = "daId",
            nullable = false
    )
    private DeliveryAddress deliveryAddress;
    private int orderState;

    @OneToMany(mappedBy = "orders",
            cascade = CascadeType.ALL)
    private List<OrderDetailet> orderDetailets = new ArrayList<>();
    public void addOrderDetail(OrderDetailet orderDetailet){
        this.orderDetailets.add(orderDetailet);
        orderDetailet.setOrders(this);
    }

    public Orders(){
        this.orderDate = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME).toString();
        this.orderState = 0;
    }
}
