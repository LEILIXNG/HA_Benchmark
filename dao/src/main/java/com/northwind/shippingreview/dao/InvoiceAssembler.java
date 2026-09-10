package com.northwind.shippingreview.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class InvoiceAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceAssembler.class);

    public static void stage(String value) {
        LOG.debug("开始整理发运字段");
        StringBuilder orderRef401Buffer = new StringBuilder("ref_");
        orderRef401Buffer.append(value);
        String orderRef401 = orderRef401Buffer.toString();
        BundleRepository.dispatch(orderRef401);
    }
}
