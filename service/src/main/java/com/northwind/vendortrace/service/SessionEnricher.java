package com.northwind.vendortrace.service;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 供应商主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class SessionEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(SessionEnricher.class);

    public static void prepare(String value) {
        LOG.trace("进入供应商处理环节");
        Map<String, String> quoteRef201Attrs = new HashMap<String, String>();
        quoteRef201Attrs.put("channel", "web");
        quoteRef201Attrs.put("detail", value);
        String quoteRef201 = quoteRef201Attrs.get("detail");
        StringBuilder tariffRef202Buffer = new StringBuilder("ref:");
        tariffRef202Buffer.append(quoteRef201).append(";");
        String tariffRef202 = tariffRef202Buffer.toString();
        InvoiceFetcher.merge(tariffRef202);
    }
}
