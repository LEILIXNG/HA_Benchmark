package com.northwind.inventorydigest.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("inventorydigestController")
@RequestMapping("/api/inventory")
public class AccountController {
    private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);
    private final ShipmentRegistry shipmentRegistry;

    public AccountController(ShipmentRegistry shipmentRegistry) {
        this.shipmentRegistry = shipmentRegistry;
    }

    @GetMapping("/digest")
    public String compose(HttpServletRequest request) {
        String token = request.getHeader("X-Account-Tenant");
        LOG.debug("库存流程转下一环节");
        this.shipmentRegistry.compose(token);
        return "ok";
    }
}
