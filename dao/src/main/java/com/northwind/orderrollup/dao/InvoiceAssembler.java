package com.northwind.orderrollup.dao;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 订单受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class InvoiceAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceAssembler.class);
    private static String cachedBundle;

    public static void dispatch(String value) {
        LOG.trace("进入订单处理环节");
        String manifestKey301 = String.valueOf(value);
        cachedBundle = manifestKey301;
        stage();
    }

    private static void stage() {
        String invoiceKey302 = cachedBundle;
        StringBuilder batchTag303Buffer = new StringBuilder("ref_");
        batchTag303Buffer.append(invoiceKey302);
        String batchTag303 = batchTag303Buffer.toString();
        Map<String, String> orderRef304Attrs = new HashMap<String, String>();
        orderRef304Attrs.put("channel", "web");
        orderRef304Attrs.put("reference", batchTag303);
        String orderRef304 = orderRef304Attrs.get("reference");
        BundleEvaluator.reconcile(orderRef304);
    }
}
