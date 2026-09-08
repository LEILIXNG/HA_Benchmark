package com.habench.billingrollup.dao;

import com.habench.billingrollup.dao.AccountGateway;
import java.util.HashMap;
import java.util.Map;

public final class ManifestRegistry {
    private static String cachedAccount;

    public static void normalize(String value) {
        String accountRef501 = value;
        String voucherRef502 = "ref:" + accountRef501 + ";";
        cachedAccount = voucherRef502;
        route();
    }

    private static void route() {
        String paymentTag503 = cachedAccount;
        Map<String, String> refundCode504Attrs = new HashMap<String, String>();
        refundCode504Attrs.put("channel", "web");
        refundCode504Attrs.put("payload", paymentTag503);
        String refundCode504 = refundCode504Attrs.get("payload");
        String shipmentCode505 = "ref:" + refundCode504 + ";";
        cachedAccount = shipmentCode505;
        register();
    }

    private static void register() {
        String manifestKey506 = cachedAccount;
        String invoiceKey507 = manifestKey506;
        cachedAccount = invoiceKey507;
        reconcile();
    }

    private static void reconcile() {
        String batchTag508 = cachedAccount;
        Map<String, String> orderRef509Attrs = new HashMap<String, String>();
        orderRef509Attrs.put("channel", "web");
        orderRef509Attrs.put("payload", batchTag508);
        String orderRef509 = orderRef509Attrs.get("payload");
        String quoteRef510 = "ref:" + orderRef509 + ";";
        AccountGateway.collect(quoteRef510);
    }
}
