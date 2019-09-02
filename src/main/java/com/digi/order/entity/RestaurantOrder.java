package com.digi.order.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_restaurant_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RestaurantOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String customerId;
    private String orderedMenu;

}
