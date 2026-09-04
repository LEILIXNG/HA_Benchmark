package com.habench.catalogassign.service;

import com.habench.catalogassign.dao.QuoteAdapter;
import java.util.HashMap;
import java.util.Map;

public final class BatchCoordinator {
    private static String cachedContract;

    public static void route(String value) {
        Map<String, String> voucherRef101Attrs = new HashMap<String, String>();
        voucherRef101Attrs.put("channel", "web");
        voucherRef101Attrs.put("payload", value);
        String voucherRef101 = voucherRef101Attrs.get("payload");
        cachedContract = voucherRef101;
        reconcile();
    }

    private static void reconcile() {
        String paymentTag102 = cachedContract;
        String refundCode103 = paymentTag102;
        Map<String, String> shipmentCode104Attrs = new HashMap<String, String>();
        shipmentCode104Attrs.put("channel", "web");
        shipmentCode104Attrs.put("payload", refundCode103);
        String shipmentCode104 = shipmentCode104Attrs.get("payload");
        QuoteAdapter.translate(shipmentCode104);
    }
}
