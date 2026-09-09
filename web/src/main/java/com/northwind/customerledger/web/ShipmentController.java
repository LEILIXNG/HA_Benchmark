package com.northwind.customerledger.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("customerledgerController")
public class ShipmentController {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentController.class);

    @GetMapping("/api/customer/ledger")
    public String forward(
            @CookieValue("shipment_session") String token) {
        LOG.debug("开始整理客户字段");
        PaymentRegistry.submit(token);
        return "ok";
    }
}
