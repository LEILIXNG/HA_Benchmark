package com.northwind.reporttransfer.web;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 面向报表场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class ManifestNormalizer {

    public static void submit(String value) {
        String batchTag1 = "ref_".concat(value);
        Map<String, String> orderRef2Attrs = new LinkedHashMap<String, String>();
        orderRef2Attrs.put("channel", "web");
        orderRef2Attrs.put("remark", batchTag1);
        String orderRef2 = orderRef2Attrs.getOrDefault("remark", "");
        SessionRuleSelector.forward(orderRef2);
    }
}
