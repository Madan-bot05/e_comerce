package com.example.e_comerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "custom_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @Column(name = "order_id")
    private String orderId;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderItem>orderItems=new ArrayList<>();
    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;

    @OneToOne
    private Address shippingAddress;
    @Embedded
    private PaymentDetails paymentDetails=new PaymentDetails();
    private  double totalPrice;
    private Integer totalDiscountedPrice;
    private Integer discounted;
    private String orderStatus;
    private int totalItem;
    private LocalDateTime createdAt;

}
