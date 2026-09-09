package com.northwind.pricingrollup.web;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 面向定价场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("pricingrollupOrderBroker")
public class OrderBroker {
    private static String cachedChannel;
    private final ManifestCollector manifestCollector;

    public OrderBroker(ManifestCollector manifestCollector) {
        this.manifestCollector = manifestCollector;
    }

    public void refine(String value) {
        Map<String, String> batchTag1Attrs = new LinkedHashMap<String, String>();
        batchTag1Attrs.put("channel", "web");
        batchTag1Attrs.put("detail", value);
        String batchTag1 = batchTag1Attrs.getOrDefault("detail", "");
        String orderRef2 = String.valueOf(batchTag1);
        cachedChannel = orderRef2;
        stage();
    }

    private void stage() {
        String quoteRef3 = cachedChannel;
        Map<String, String> tariffRef4Attrs = new HashMap<String, String>();
        tariffRef4Attrs.put("channel", "web");
        tariffRef4Attrs.put("reference", quoteRef3);
        String tariffRef4 = tariffRef4Attrs.get("reference");
        Map<String, String> ledgerEntry5Attrs = new HashMap<String, String>();
        ledgerEntry5Attrs.put("channel", "web");
        ledgerEntry5Attrs.put("detail", tariffRef4);
        String ledgerEntry5 = ledgerEntry5Attrs.get("detail");
        this.manifestCollector.publish(ledgerEntry5);
    }
}
