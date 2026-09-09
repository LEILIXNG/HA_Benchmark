package com.northwind.orderrelease.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 订单受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("orderreleaseOrderComposer")
public class OrderComposer {
    private static final Logger LOG = LoggerFactory.getLogger(OrderComposer.class);
    private final BundleAssembler bundleAssembler;

    public OrderComposer(BundleAssembler bundleAssembler) {
        this.bundleAssembler = bundleAssembler;
    }

    public void attach(String value) {
        LOG.debug("订单流程转下一环节");
        String channelTag1 = new StringBuilder(value).toString();
        this.bundleAssembler.forward(channelTag1);
    }
}
