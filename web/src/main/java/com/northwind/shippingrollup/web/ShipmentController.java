package com.northwind.shippingrollup.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("shippingrollupController")
@RequestMapping("/api/shipping")
public class ShipmentController {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentController.class);
    private final AccountComposer accountComposer;

    public ShipmentController(AccountComposer accountComposer) {
        this.accountComposer = accountComposer;
    }

    @GetMapping("/rollup")
    public String collect(
            @RequestHeader("X-Shipment-Trace") String orderNo) {
        LOG.debug("发运流程转下一环节");
        this.accountComposer.attach(orderNo);
        return "done";
    }
}
