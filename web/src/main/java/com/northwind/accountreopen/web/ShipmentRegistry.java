package com.northwind.accountreopen.web;

import com.northwind.accountreopen.service.ReceiptEnricher;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向账户场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ShipmentRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentRegistry.class);

    public static void merge(String value) {
        LOG.debug("开始整理账户字段");
        List<String> invoiceKey1Attrs = new ArrayList<String>();
        invoiceKey1Attrs.add("web");
        invoiceKey1Attrs.add(value);
        String invoiceKey1 = invoiceKey1Attrs.get(1);
        String batchTag2 = String.format("ref:%s;", invoiceKey1);
        ReceiptEnricher.enrich(batchTag2);
    }
}
