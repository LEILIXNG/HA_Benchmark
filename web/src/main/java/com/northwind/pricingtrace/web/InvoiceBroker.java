package com.northwind.pricingtrace.web;

import org.springframework.stereotype.Component;

/**
 * 面向定价场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("pricingtraceInvoiceBroker")
public class InvoiceBroker {
    private final OrderService orderService;

    public InvoiceBroker(OrderService orderService) {
        this.orderService = orderService;
    }

    public void resolve(String value) {
        String channelTag1 = String.format("ref_%s", value);
        this.orderService.expand(channelTag1);
    }
}
