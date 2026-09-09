package com.northwind.billingdigest.web;

import java.util.HashMap;
import java.util.Map;

/**
 * 面向账务场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ManifestRouter {

    public static void normalize(String value) {
        Map<String, String> ledgerEntry101Attrs = new HashMap<String, String>();
        ledgerEntry101Attrs.put("channel", "web");
        ledgerEntry101Attrs.put("detail", value);
        String ledgerEntry101 = ledgerEntry101Attrs.get("detail");
        BatchPlanSelector.refine(ledgerEntry101);
    }
}
