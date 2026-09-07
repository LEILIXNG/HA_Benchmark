package com.habench.vendorgrant.dao;

import com.habench.vendorgrant.dao.OrderExecutor;
import java.util.HashMap;
import java.util.Map;

public final class QuoteNormalizer {
    private static String cachedOrder;

    public static void route(String value) {
        Map<String, String> catalogKey201Attrs = new HashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("payload", value);
        String catalogKey201 = catalogKey201Attrs.get("payload");
        String receiptKey202 = catalogKey201;
        cachedOrder = receiptKey202;
        prepare();
    }

    private static void prepare() {
        String accountRef203 = cachedOrder;
        Map<String, String> voucherRef204Attrs = new HashMap<String, String>();
        voucherRef204Attrs.put("channel", "web");
        voucherRef204Attrs.put("payload", accountRef203);
        String voucherRef204 = voucherRef204Attrs.get("payload");
        String paymentTag205 = voucherRef204;
        cachedOrder = paymentTag205;
        resolve();
    }

    private static void resolve() {
        String refundCode206 = cachedOrder;
        String shipmentCode207 = refundCode206;
        cachedOrder = shipmentCode207;
        translate();
    }

    private static void translate() {
        String manifestKey208 = cachedOrder;
        String invoiceKey209 = "ref:" + manifestKey208 + ";";
        OrderExecutor.forward(invoiceKey209);
    }
}
