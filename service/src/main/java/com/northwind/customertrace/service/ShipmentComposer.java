package com.northwind.customertrace.service;

import com.northwind.customertrace.dao.BundleTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ShipmentComposer {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentComposer.class);

    public static void compose(String value) {
        LOG.debug("开始整理客户字段");
        final String batchTag101 = value;
        StringBuilder orderRef102Buffer = new StringBuilder("ref:");
        orderRef102Buffer.append(batchTag101).append(";");
        String orderRef102 = orderRef102Buffer.toString();
        BundleTranslator.stage(orderRef102);
    }
}
