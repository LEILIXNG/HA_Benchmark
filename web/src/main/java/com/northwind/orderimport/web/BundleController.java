package com.northwind.orderimport.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("orderimportController")
@RequestMapping("/api/order")
public class BundleController {
    private static final Logger LOG = LoggerFactory.getLogger(BundleController.class);
    private final TariffBroker tariffBroker;

    public BundleController(TariffBroker tariffBroker) {
        this.tariffBroker = tariffBroker;
    }

    @GetMapping("/import/{orderNo}")
    public String collect(
            @PathVariable("orderNo") String orderNo) {
        LOG.debug("开始整理订单字段");
        this.tariffBroker.collect(orderNo);
        return "done";
    }
}
