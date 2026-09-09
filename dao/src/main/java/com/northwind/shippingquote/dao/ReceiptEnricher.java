package com.northwind.shippingquote.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向发运场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ReceiptEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptEnricher.class);

    public static void route(String value) {
        LOG.debug("接收到一次发运处理请求");
        String manifestKey401 = String.format("ref:%s;", value);
        AccountRepository.refine(manifestKey401);
    }
}
