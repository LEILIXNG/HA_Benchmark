package com.northwind.inventoryrelease.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class InvoiceResolver {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceResolver.class);

    public static void normalize(String value) {
        LOG.debug("开始整理库存字段");
        String shipmentCode101 = "ref:".concat(value).concat(";");
        OrderCollector.translate(shipmentCode101);
    }
}
