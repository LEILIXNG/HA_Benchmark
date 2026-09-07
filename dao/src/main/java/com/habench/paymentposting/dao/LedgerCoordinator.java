package com.habench.paymentposting.dao;

import com.habench.paymentposting.dao.CatalogAdapter;
import java.util.HashMap;
import java.util.Map;

public final class LedgerCoordinator {
    private static String cachedSession;

    public static void route(String value) {
        String accountRef401 = "ref:" + value + ";";
        String voucherRef402 = accountRef401;
        cachedSession = voucherRef402;
        compose();
    }

    private static void compose() {
        String paymentTag403 = cachedSession;
        Map<String, String> refundCode404Attrs = new HashMap<String, String>();
        refundCode404Attrs.put("channel", "web");
        refundCode404Attrs.put("payload", paymentTag403);
        String refundCode404 = refundCode404Attrs.get("payload");
        CatalogAdapter.reconcile(refundCode404);
    }
}
