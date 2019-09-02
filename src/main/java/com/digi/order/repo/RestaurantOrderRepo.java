package com.digi.order.repo;

import com.digi.order.entity.RestaurantOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantOrderRepo extends JpaRepository<RestaurantOrder,Long> {
}
