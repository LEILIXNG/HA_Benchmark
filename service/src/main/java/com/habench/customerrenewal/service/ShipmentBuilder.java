package com.habench.customerrenewal.service;

import com.habench.customerrenewal.dao.CatalogEnricher;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBuilder {
    private String pendingQuote;
    private static String cachedQuote;

    public static void resolve(String value) {
        ShipmentBuilder self = new ShipmentBuilder();
        self.merge(value);
    }

    private void merge(String value) {
        Map<String, String> receiptKey201Attrs = new HashMap<String, String>();
        receiptKey201Attrs.put("channel", "web");
        receiptKey201Attrs.put("payload", value);
        String receiptKey201 = receiptKey201Attrs.get("payload");
        cachedQuote = receiptKey201;
        collect();
    }

    private void collect() {
        String accountRef202 = cachedQuote;
        Map<String, String> voucherRef203Attrs = new HashMap<String, String>();
        voucherRef203Attrs.put("channel", "web");
        voucherRef203Attrs.put("payload", accountRef202);
        String voucherRef203 = voucherRef203Attrs.get("payload");
        String paymentTag204 = "ref:" + voucherRef203 + ";";
        this.pendingQuote = paymentTag204;
        stage();
    }

    private void stage() {
        String refundCode205 = this.pendingQuote;
        String shipmentCode206 = refundCode205;
        cachedQuote = shipmentCode206;
        submit();
    }

    private void submit() {
        String manifestKey207 = cachedQuote;
        String invoiceKey208 = "ref:" + manifestKey207 + ";";
        CatalogEnricher.dispatch(invoiceKey208);
    }
}
