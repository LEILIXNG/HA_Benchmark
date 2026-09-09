package com.northwind.shippinglookup.service;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 发运主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class RefundCollector {

    public static void translate(String value) {
        Map<String, String> quoteRef401Attrs = new LinkedHashMap<String, String>();
        quoteRef401Attrs.put("channel", "web");
        quoteRef401Attrs.put("detail", value);
        String quoteRef401 = quoteRef401Attrs.getOrDefault("detail", "");
        TariffRepository.compose(quoteRef401);
    }
}
