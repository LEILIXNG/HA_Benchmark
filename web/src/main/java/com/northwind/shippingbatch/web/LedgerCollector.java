package com.northwind.shippingbatch.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class LedgerCollector {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerCollector.class);

    public static void enrich(String value) {
        LOG.trace("进入发运处理环节");
        StringBuilder catalogKey201Buffer = new StringBuilder("ref:");
        catalogKey201Buffer.append(value).append(";");
        String catalogKey201 = catalogKey201Buffer.toString();
        String receiptKey202 = catalogKey201;
        CatalogExecutor.stage(receiptKey202);
    }
}
