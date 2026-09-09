package com.northwind.shippingsubmit.dao;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class QuoteEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteEnricher.class);

    public static void publish(String value) {
        LOG.trace("进入发运处理环节");
        Map<String, String> quoteRef601Attrs = new LinkedHashMap<String, String>();
        quoteRef601Attrs.put("channel", "web");
        quoteRef601Attrs.put("detail", value);
        String quoteRef601 = quoteRef601Attrs.getOrDefault("detail", "");
        BundleExecutor.enrich(quoteRef601);
    }
}
