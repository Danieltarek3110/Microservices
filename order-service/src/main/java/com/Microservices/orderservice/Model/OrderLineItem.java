package com.Microservices.orderservice.Model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "t_order_line-items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;


}
