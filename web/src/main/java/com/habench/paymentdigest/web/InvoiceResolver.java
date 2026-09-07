package com.habench.paymentdigest.web;

import com.habench.paymentdigest.service.VoucherAdapter;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceResolver {
    private static String cachedContract;

    public static void route(String value) {
        String paymentTag1 = value;
        String refundCode2 = "ref:" + paymentTag1 + ";";
        cachedContract = refundCode2;
        dispatch();
    }

    private static void dispatch() {
        String shipmentCode3 = cachedContract;
        Map<String, String> manifestKey4Attrs = new HashMap<String, String>();
        manifestKey4Attrs.put("channel", "web");
        manifestKey4Attrs.put("payload", shipmentCode3);
        String manifestKey4 = manifestKey4Attrs.get("payload");
        cachedContract = manifestKey4;
        forward();
    }

    private static void forward() {
        String invoiceKey5 = cachedContract;
        String batchTag6 = invoiceKey5;
        VoucherAdapter.translate(batchTag6);
    }
}
