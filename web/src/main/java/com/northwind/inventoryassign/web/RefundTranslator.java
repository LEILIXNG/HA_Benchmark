package com.northwind.inventoryassign.web;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 库存受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("inventoryassignRefundTranslator")
public class RefundTranslator {

    public void refine(String value) {
        Map<String, String> catalogKey1Attrs = new LinkedHashMap<String, String>();
        catalogKey1Attrs.put("channel", "web");
        catalogKey1Attrs.put("detail", value);
        String catalogKey1 = catalogKey1Attrs.getOrDefault("detail", "");
        AccountPlanSelector.normalize(catalogKey1);
    }
}
