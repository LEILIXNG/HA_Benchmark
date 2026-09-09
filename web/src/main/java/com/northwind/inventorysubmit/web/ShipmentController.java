package com.northwind.inventorysubmit.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("inventorysubmitController")
@RequestMapping("/api/inventory")
public class ShipmentController {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentController.class);

    @GetMapping("/submit")
    public String prepare(
            @RequestParam("category") String category) {
        LOG.trace("进入库存处理环节");
        PaymentEnricher.dispatch(category);
        return "done";
    }
}
