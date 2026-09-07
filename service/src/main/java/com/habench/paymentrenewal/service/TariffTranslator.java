package com.habench.paymentrenewal.service;

import com.habench.paymentrenewal.service.ManifestEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class TariffTranslator {
    private String pendingManifest;
    private static String cachedManifest;

    public static void submit(String value) {
        TariffTranslator self = new TariffTranslator();
        self.enrich(value);
    }

    private void enrich(String value) {
        String catalogKey301 = "ref:" + value + ";";
        this.pendingManifest = catalogKey301;
        compose();
    }

    private void compose() {
        String receiptKey302 = this.pendingManifest;
        String accountRef303 = receiptKey302;
        String voucherRef304 = "ref:" + accountRef303 + ";";
        cachedManifest = voucherRef304;
        translate();
    }

    private void translate() {
        String paymentTag305 = cachedManifest;
        String refundCode306 = paymentTag305;
        String shipmentCode307 = refundCode306;
        cachedManifest = shipmentCode307;
        refine();
    }

    private void refine() {
        String manifestKey308 = cachedManifest;
        String invoiceKey309 = manifestKey308;
        cachedManifest = invoiceKey309;
        normalize();
    }

    private void normalize() {
        String batchTag310 = cachedManifest;
        Map<String, String> orderRef311Attrs = new HashMap<String, String>();
        orderRef311Attrs.put("channel", "web");
        orderRef311Attrs.put("payload", batchTag310);
        String orderRef311 = orderRef311Attrs.get("payload");
        cachedManifest = orderRef311;
        expand();
    }

    private void expand() {
        String quoteRef312 = cachedManifest;
        String tariffRef313 = quoteRef312;
        String ledgerEntry314 = "ref:" + tariffRef313 + ";";
        ManifestEvaluator.resolve(ledgerEntry314);
    }
}
