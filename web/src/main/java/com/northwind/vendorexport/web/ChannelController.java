package com.northwind.vendorexport.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 供应商受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("vendorexportController")
@RequestMapping("/api/vendor")
public class ChannelController {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelController.class);
    private final ShipmentResolver shipmentResolver;

    public ChannelController(ShipmentResolver shipmentResolver) {
        this.shipmentResolver = shipmentResolver;
    }

    @GetMapping("/export")
    public String refine(
            @RequestParam("keyword") String keyword) {
        LOG.debug("开始整理供应商字段");
        this.shipmentResolver.stage(keyword);
        return "done";
    }
}
