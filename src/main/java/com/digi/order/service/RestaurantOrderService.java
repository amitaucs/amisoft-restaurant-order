package com.digi.order.service;

import com.digi.order.entity.RestaurantOrder;
import com.digi.order.model.CustomerOrder;
import com.digi.order.model.OrderResponse;
import com.digi.order.repo.RestaurantOrderRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.digi.order.constant.RestaurantOrderConstant.EXCHANGE_NAME;
import static com.digi.order.constant.RestaurantOrderConstant.ROUTING_KEY;

@Service
@Slf4j
public class RestaurantOrderService {

    @Autowired
    RestaurantOrderRepo restaurantOrderRepo;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public OrderResponse saveOrder(CustomerOrder customerOrder){

        RestaurantOrder restaurantOrder = new RestaurantOrder();
        BeanUtils.copyProperties(customerOrder,restaurantOrder);
        restaurantOrder = restaurantOrderRepo.save(restaurantOrder);
        OrderResponse orderResponse = new OrderResponse();
        BeanUtils.copyProperties(restaurantOrder, orderResponse);
        orderResponse.setMessage("Order placed successfully");

        log.info("Pushing create order event");
        rabbitTemplate.convertAndSend(EXCHANGE_NAME,ROUTING_KEY,orderResponse);

        return orderResponse;
    }
}
