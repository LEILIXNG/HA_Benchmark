package com.northwind.paymentrelease.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class OrderBroker {
    private static final Logger LOG = LoggerFactory.getLogger(OrderBroker.class);
    private static String cachedChannel;

    public static void enrich(String value) {
        LOG.trace("进入支付处理环节");
        String receiptKey301 = value;
        cachedChannel = receiptKey301;
        reconcile();
    }

    private static void reconcile() {
        String accountRef302 = cachedChannel;
        StringBuilder voucherRef303Buffer = new StringBuilder("ref_");
        voucherRef303Buffer.append(accountRef302);
        String voucherRef303 = voucherRef303Buffer.toString();
        CatalogService.refine(voucherRef303);
    }
}
