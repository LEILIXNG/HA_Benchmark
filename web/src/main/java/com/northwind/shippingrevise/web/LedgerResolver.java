package com.northwind.shippingrevise.web;

import com.northwind.shippingrevise.service.ShipmentAdapter;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向发运场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class LedgerResolver {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerResolver.class);

    public static void refine(String value) {
        LOG.trace("进入发运处理环节");
        Map<String, String> invoiceKey1Attrs = new HashMap<String, String>();
        invoiceKey1Attrs.put("channel", "web");
        invoiceKey1Attrs.put("detail", value);
        String invoiceKey1 = invoiceKey1Attrs.get("detail");
        String batchTag2 = new StringBuilder(invoiceKey1).toString();
        ShipmentAdapter.attach(batchTag2);
    }
}
