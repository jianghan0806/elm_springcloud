package edu.ynu.ls.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;
    @JsonIgnore
    private String password;
    private String userName;
    private int userSex;
    @Column(columnDefinition = "mediumtext")
    private String userImg;
    private int delTag;
    @JsonIgnore
    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "user",
            orphanRemoval = true
    )
    private List<Cart> cart;
    @JsonIgnore
    @OneToMany(mappedBy = "user",
            orphanRemoval = true,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<DeliveryAddress> deliveryAddresses;
    @JsonIgnore
    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL)
    private List<Orders> orders;
    public void addCarts(Cart cart){
        this.cart.add(cart);
        cart.setUser(this);
    }

    public void addOrders(Orders orders){
        this.orders.add(orders);
        orders.setUser(this);
    }

    public void addDeliveryAddresses(DeliveryAddress deliveryAddress){
        this.deliveryAddresses.add(deliveryAddress);
        deliveryAddress.setUser(this);
    }
    public void removeDeliveryAddress(DeliveryAddress deliveryAddress) {
        if (deliveryAddress != null) {
            this.deliveryAddresses.remove(deliveryAddress);
            deliveryAddress.setUser(null);
        }
    }
    public void removeCarts(Cart cart){
        this.cart.remove(cart);
        cart.setUser(null);
    }
}
