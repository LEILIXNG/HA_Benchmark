package com.northwind.vendordispatch.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 供应商受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class QuoteCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteCoordinator.class);

    public static void publish(String value) {
        LOG.trace("进入供应商处理环节");
        String quoteRef101 = new StringBuilder(value).toString();
        TariffGateway.route(quoteRef101);
    }
}
