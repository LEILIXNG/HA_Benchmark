package com.habench.paymentdigest.dao;

import com.habench.paymentdigest.dao.TariffEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class CatalogResolver {
    private String pendingTariff;
    private static String cachedTariff;

    public static void reconcile(String value) {
        CatalogResolver self = new CatalogResolver();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String shipmentCode501 = value;
        cachedTariff = shipmentCode501;
        merge();
    }

    private void merge() {
        String manifestKey502 = cachedTariff;
        String invoiceKey503 = "ref:" + manifestKey502 + ";";
        this.pendingTariff = invoiceKey503;
        expand();
    }

    private void expand() {
        String batchTag504 = this.pendingTariff;
        String orderRef505 = "ref:" + batchTag504 + ";";
        Map<String, String> quoteRef506Attrs = new HashMap<String, String>();
        quoteRef506Attrs.put("channel", "web");
        quoteRef506Attrs.put("payload", orderRef505);
        String quoteRef506 = quoteRef506Attrs.get("payload");
        TariffEvaluator.merge(quoteRef506);
    }
}
