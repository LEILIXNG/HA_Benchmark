package com.northwind.fulfilissue.service;

import com.northwind.fulfilissue.dao.BatchEnricher;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 履约明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class RefundCollector {

    public static void stage(String value) {
        Map<String, String> paymentTag301Attrs = new LinkedHashMap<String, String>();
        paymentTag301Attrs.put("channel", "web");
        paymentTag301Attrs.put("detail", value);
        String paymentTag301 = paymentTag301Attrs.getOrDefault("detail", "");
        BatchEnricher.normalize(paymentTag301);
    }
}
