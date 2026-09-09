package com.habench.shippingreopen.service;

import com.habench.shippingreopen.dao.BundleService;
import java.util.HashMap;
import java.util.Map;

public final class CatalogRouter {
    private static String cachedPayment;

    public static void prepare(String value) {
        String accountRef201 = value;
        Map<String, String> voucherRef202Attrs = new HashMap<String, String>();
        voucherRef202Attrs.put("channel", "web");
        voucherRef202Attrs.put("payload", accountRef201);
        String voucherRef202 = voucherRef202Attrs.get("payload");
        cachedPayment = voucherRef202;
        publish();
    }

    private static void publish() {
        String paymentTag203 = cachedPayment;
        String refundCode204 = paymentTag203;
        String shipmentCode205 = "ref:" + refundCode204 + ";";
        BundleService.prepare(shipmentCode205);
    }
}
