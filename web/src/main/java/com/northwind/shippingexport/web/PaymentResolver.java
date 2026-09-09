package com.northwind.shippingexport.web;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 发运受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class PaymentResolver {

    public static void forward(String value) {
        Map<String, String> voucherRef201Attrs = new LinkedHashMap<String, String>();
        voucherRef201Attrs.put("channel", "web");
        voucherRef201Attrs.put("detail", value);
        String voucherRef201 = voucherRef201Attrs.getOrDefault("detail", "");
        BundlePolicy.enrich(voucherRef201);
    }
}
