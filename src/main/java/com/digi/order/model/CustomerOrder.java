package com.digi.order.model;


import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CustomerOrder {

    @NonNull
    private String customerId;
    @NonNull
    private String orderedMenu;
}
