package com.northwind.paymentdigest.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class CatalogResolver {
    private String pendingTariff;
    private static String cachedTariff;

    public static void reconcile(String value) {
        CatalogResolver self = new CatalogResolver();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        final String shipmentCode501 = value;
        cachedTariff = shipmentCode501;
        merge();
    }

    private void merge() {
        String manifestKey502 = cachedTariff;
        StringBuilder invoiceKey503Buffer = new StringBuilder("ref_");
        invoiceKey503Buffer.append(manifestKey502);
        String invoiceKey503 = invoiceKey503Buffer.toString();
        this.pendingTariff = invoiceKey503;
        expand();
    }

    private void expand() {
        String batchTag504 = this.pendingTariff;
        String orderRef505 = "ref_".concat(batchTag504);
        Map<String, String> quoteRef506Attrs = new HashMap<String, String>();
        quoteRef506Attrs.put("channel", "web");
        quoteRef506Attrs.put("remark", orderRef505);
        String quoteRef506 = quoteRef506Attrs.get("remark");
        TariffEvaluator.merge(quoteRef506);
    }
}
