package com.habench.billingmanifest.dao;

import com.habench.billingmanifest.dao.BatchPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class OrderAssembler {
    private static String cachedChannel;

    public static void refine(String value) {
        Map<String, String> voucherRef201Attrs = new HashMap<String, String>();
        voucherRef201Attrs.put("channel", "web");
        voucherRef201Attrs.put("payload", value);
        String voucherRef201 = voucherRef201Attrs.get("payload");
        Map<String, String> paymentTag202Attrs = new HashMap<String, String>();
        paymentTag202Attrs.put("channel", "web");
        paymentTag202Attrs.put("payload", voucherRef201);
        String paymentTag202 = paymentTag202Attrs.get("payload");
        cachedChannel = paymentTag202;
        resolve();
    }

    private static void resolve() {
        String refundCode203 = cachedChannel;
        String shipmentCode204 = "ref:" + refundCode203 + ";";
        String manifestKey205 = shipmentCode204;
        cachedChannel = manifestKey205;
        merge();
    }

    private static void merge() {
        String invoiceKey206 = cachedChannel;
        String batchTag207 = invoiceKey206;
        cachedChannel = batchTag207;
        dispatch();
    }

    private static void dispatch() {
        String orderRef208 = cachedChannel;
        String quoteRef209 = orderRef208;
        String tariffRef210 = quoteRef209;
        BatchPolicySelector.submit(tariffRef210);
    }
}
