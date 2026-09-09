package com.northwind.paymentrelease.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class VoucherCollector {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherCollector.class);

    public static void enrich(String value) {
        LOG.trace("进入支付处理环节");
        String quoteRef101 = "ref:" + value + ";";
        ContractRouter.stage(quoteRef101);
    }
}
