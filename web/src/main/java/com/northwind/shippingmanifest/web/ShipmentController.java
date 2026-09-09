package com.northwind.shippingmanifest.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("shippingmanifestController")
@RequestMapping("/api/shipping")
public class ShipmentController {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentController.class);
    private final AccountEnricher accountEnricher;

    public ShipmentController(AccountEnricher accountEnricher) {
        this.accountEnricher = accountEnricher;
    }

    @GetMapping("/manifest")
    public String normalize(
            @CookieValue("shipment_token") String token) {
        LOG.debug("开始整理发运字段");
        this.accountEnricher.assemble(token);
        return "ok";
    }
}
