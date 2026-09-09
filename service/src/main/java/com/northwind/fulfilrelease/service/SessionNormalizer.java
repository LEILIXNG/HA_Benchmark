package com.northwind.fulfilrelease.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 履约明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class SessionNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(SessionNormalizer.class);

    public static void collect(String value) {
        LOG.trace("进入履约处理环节");
        String refundCode101 = new StringBuilder(value).toString();
        PaymentGateway.submit(refundCode101);
    }
}
