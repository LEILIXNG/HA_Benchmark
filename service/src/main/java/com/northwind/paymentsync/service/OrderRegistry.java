package com.northwind.paymentsync.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向支付场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class OrderRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(OrderRegistry.class);

    public static void collect(String value) {
        LOG.trace("进入支付处理环节");
        String receiptKey201 = String.format("ref:%s;", value);
        ShipmentExecutor.route(receiptKey201);
    }
}
