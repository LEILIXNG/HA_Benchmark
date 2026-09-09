package com.northwind.paymentdigest.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向支付场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("paymentdigestController")
public class TariffController {
    private final ShipmentResolver shipmentResolver;

    public TariffController(ShipmentResolver shipmentResolver) {
        this.shipmentResolver = shipmentResolver;
    }

    @GetMapping("/api/payment/digest/{orderNo}")
    public String collect(
            @PathVariable("orderNo") String orderNo) {
        this.shipmentResolver.prepare(orderNo);
        return "ok";
    }
}
