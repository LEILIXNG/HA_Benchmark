package com.northwind.inventorynotice.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class VoucherAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherAssembler.class);

    public static void prepare(String value) {
        LOG.debug("开始整理库存字段");
        StringBuilder invoiceKey201Buffer = new StringBuilder("ref_");
        invoiceKey201Buffer.append(value);
        String invoiceKey201 = invoiceKey201Buffer.toString();
        VoucherCollector.prepare(invoiceKey201);
    }
}
