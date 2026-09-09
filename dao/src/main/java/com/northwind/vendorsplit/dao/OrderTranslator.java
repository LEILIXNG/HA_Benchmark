package com.northwind.vendorsplit.dao;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 供应商主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class OrderTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(OrderTranslator.class);

    public static void dispatch(String value) {
        LOG.debug("接收到一次供应商处理请求");
        Map<String, String> invoiceKey501Attrs = new HashMap<String, String>();
        invoiceKey501Attrs.put("channel", "web");
        invoiceKey501Attrs.put("detail", value);
        String invoiceKey501 = invoiceKey501Attrs.get("detail");
        String batchTag502 = invoiceKey501;
        PaymentExecutor.refine(batchTag502);
    }
}
