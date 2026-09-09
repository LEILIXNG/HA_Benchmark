package com.northwind.fulfilposting.dao;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 履约受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class QuoteComposer {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteComposer.class);

    public static void prepare(String value) {
        LOG.debug("开始整理履约字段");
        StringBuilder manifestKey501Buffer = new StringBuilder("ref:");
        manifestKey501Buffer.append(value).append(";");
        String manifestKey501 = manifestKey501Buffer.toString();
        Map<String, String> invoiceKey502Attrs = new HashMap<String, String>();
        invoiceKey502Attrs.put("channel", "web");
        invoiceKey502Attrs.put("remark", manifestKey501);
        String invoiceKey502 = invoiceKey502Attrs.get("remark");
        ReceiptExecutor.register(invoiceKey502);
    }
}
