package com.habench.vendorrevise.dao;

import com.habench.vendorrevise.dao.OrderExecutor;
import java.util.HashMap;
import java.util.Map;

public final class BundleBuilder {
    private String pendingOrder;
    private static String cachedOrder;

    public static void reconcile(String value) {
        BundleBuilder self = new BundleBuilder();
        self.route(value);
    }

    private void route(String value) {
        Map<String, String> catalogKey301Attrs = new HashMap<String, String>();
        catalogKey301Attrs.put("channel", "web");
        catalogKey301Attrs.put("payload", value);
        String catalogKey301 = catalogKey301Attrs.get("payload");
        String receiptKey302 = catalogKey301;
        cachedOrder = receiptKey302;
        normalize();
    }

    private void normalize() {
        String accountRef303 = cachedOrder;
        Map<String, String> voucherRef304Attrs = new HashMap<String, String>();
        voucherRef304Attrs.put("channel", "web");
        voucherRef304Attrs.put("payload", accountRef303);
        String voucherRef304 = voucherRef304Attrs.get("payload");
        cachedOrder = voucherRef304;
        compose();
    }

    private void compose() {
        String paymentTag305 = cachedOrder;
        String refundCode306 = paymentTag305;
        this.pendingOrder = refundCode306;
        submit();
    }

    private void submit() {
        String shipmentCode307 = this.pendingOrder;
        Map<String, String> manifestKey308Attrs = new HashMap<String, String>();
        manifestKey308Attrs.put("channel", "web");
        manifestKey308Attrs.put("payload", shipmentCode307);
        String manifestKey308 = manifestKey308Attrs.get("payload");
        String invoiceKey309 = "ref:" + manifestKey308 + ";";
        cachedOrder = invoiceKey309;
        collect();
    }

    private void collect() {
        String batchTag310 = cachedOrder;
        String orderRef311 = batchTag310;
        String quoteRef312 = orderRef311;
        OrderExecutor.stage(quoteRef312);
    }
}
