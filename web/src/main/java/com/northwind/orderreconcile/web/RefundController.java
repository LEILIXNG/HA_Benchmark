package com.northwind.orderreconcile.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("orderreconcileController")
@RequestMapping("/api/order")
public class RefundController {
    private static final Logger LOG = LoggerFactory.getLogger(RefundController.class);
    private final ShipmentCollector shipmentCollector;

    public RefundController(ShipmentCollector shipmentCollector) {
        this.shipmentCollector = shipmentCollector;
    }

    @GetMapping("/reconcile")
    public ResponseEntity<String> reconcile(HttpServletRequest request) {
        String reference = request.getHeader("X-Refund-Origin");
        LOG.trace("进入订单处理环节");
        this.shipmentCollector.publish(reference);
        return ResponseEntity.ok("ok");
    }
}
