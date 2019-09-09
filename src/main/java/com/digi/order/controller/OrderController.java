package com.digi.order.controller;


import com.digi.order.model.CustomerOrder;
import com.digi.order.model.OrderResponse;
import com.digi.order.service.RestaurantOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin(value="*")
@Slf4j
public class OrderController {

    @Value("${message:Hello default}")
    private String message;

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

        log.info("CustomerId is :"+consumerId);
        return new ResponseEntity<>(new OrderResponse("From Order :"+message),HttpStatus.OK);
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<OrderResponse> getOrder(){
        return new ResponseEntity<>(new OrderResponse("From Order :"+message),HttpStatus.OK);
    }
}
