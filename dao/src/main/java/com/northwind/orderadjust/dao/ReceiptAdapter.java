package com.northwind.orderadjust.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 订单明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ReceiptAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptAdapter.class);

    public static void dispatch(String value) {
        LOG.debug("开始整理订单字段");
        String invoiceKey201 = "ref:".concat(value).concat(";");
        CatalogScreen.submit(invoiceKey201);
    }
}
