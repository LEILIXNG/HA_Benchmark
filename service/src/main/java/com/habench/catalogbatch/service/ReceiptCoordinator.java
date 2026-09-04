package com.habench.catalogbatch.service;

import com.habench.catalogbatch.service.AccountExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptCoordinator {
    private static String cachedAccount;

    public static void translate(String value) {
        Map<String, String> voucherRef201Attrs = new HashMap<String, String>();
        voucherRef201Attrs.put("channel", "web");
        voucherRef201Attrs.put("payload", value);
        String voucherRef201 = voucherRef201Attrs.get("payload");
        cachedAccount = voucherRef201;
        compose();
    }

    private static void compose() {
        String paymentTag202 = cachedAccount;
        Map<String, String> refundCode203Attrs = new HashMap<String, String>();
        refundCode203Attrs.put("channel", "web");
        refundCode203Attrs.put("payload", paymentTag202);
        String refundCode203 = refundCode203Attrs.get("payload");
        Map<String, String> shipmentCode204Attrs = new HashMap<String, String>();
        shipmentCode204Attrs.put("channel", "web");
        shipmentCode204Attrs.put("payload", refundCode203);
        String shipmentCode204 = shipmentCode204Attrs.get("payload");
        cachedAccount = shipmentCode204;
        expand();
    }

    private static void expand() {
        String manifestKey205 = cachedAccount;
        String invoiceKey206 = manifestKey205;
        AccountExecutor.collect(invoiceKey206);
    }
}
