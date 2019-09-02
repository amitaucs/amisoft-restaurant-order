package com.digi.order.controller;


import com.digi.order.model.CustomerOrder;
import com.digi.order.model.OrderResponse;
import com.digi.order.service.RestaurantOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin(value="*")
public class OrderController {

    @Autowired
    RestaurantOrderService restaurantOrderService;
    @PostMapping(path = "/createOrder")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody CustomerOrder consumerOrder){

        OrderResponse orderResponse = restaurantOrderService.saveOrder(consumerOrder);
        return new ResponseEntity<>(orderResponse, HttpStatus.OK);

    }

    @PutMapping(path = "/reviseOrder")
    public ResponseEntity<OrderResponse> reviseOrder (@RequestBody CustomerOrder consumerOrder){

        return null;
    }

    @PutMapping(path = "/cancelOrder")
    public ResponseEntity<OrderResponse> cancelOrder (@RequestBody CustomerOrder consumerOrder){

        return null;
    }

    @GetMapping("/getOrder")
    public ResponseEntity<OrderResponse> getOrder(@RequestParam(value="consumerId") String consumerId) {

        return null;
    }
}
