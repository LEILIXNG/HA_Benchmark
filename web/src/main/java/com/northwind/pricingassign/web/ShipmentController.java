package com.northwind.pricingassign.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向定价场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("pricingassignController")
@RequestMapping("/api/pricing")
public class ShipmentController {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentController.class);
    private final TariffAssembler tariffAssembler;

    public ShipmentController(TariffAssembler tariffAssembler) {
        this.tariffAssembler = tariffAssembler;
    }

    @GetMapping("/assign")
    public ResponseEntity<String> expand(
            @RequestHeader("X-Shipment-Origin") String label) {
        LOG.debug("接收到一次定价处理请求");
        this.tariffAssembler.stage(label);
        return ResponseEntity.ok("accepted");
    }
}
