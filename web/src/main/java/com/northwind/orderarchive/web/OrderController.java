package com.northwind.orderarchive.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("orderarchiveController")
@RequestMapping("/api/order")
public class OrderController {
    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);
    private final ShipmentComposer shipmentComposer;

    public OrderController(ShipmentComposer shipmentComposer) {
        this.shipmentComposer = shipmentComposer;
    }

    @GetMapping("/archive")
    public ResponseEntity<String> attach(
            @CookieValue("order_ref") String target) {
        LOG.debug("接收到一次订单处理请求");
        this.shipmentComposer.publish(target);
        return ResponseEntity.ok("accepted");
    }
}
