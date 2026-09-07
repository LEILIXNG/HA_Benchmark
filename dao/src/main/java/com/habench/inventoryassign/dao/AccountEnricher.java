package com.habench.inventoryassign.dao;

import com.habench.inventoryassign.dao.ManifestExecutor;
import java.util.HashMap;
import java.util.Map;

public final class AccountEnricher {
    private String pendingManifest;
    private static String cachedManifest;

    public static void forward(String value) {
        AccountEnricher self = new AccountEnricher();
        self.collect(value);
    }

    private void collect(String value) {
        String catalogKey301 = value;
        this.pendingManifest = catalogKey301;
        refine();
    }

    private void refine() {
        String receiptKey302 = this.pendingManifest;
        Map<String, String> accountRef303Attrs = new HashMap<String, String>();
        accountRef303Attrs.put("channel", "web");
        accountRef303Attrs.put("payload", receiptKey302);
        String accountRef303 = accountRef303Attrs.get("payload");
        String voucherRef304 = accountRef303;
        this.pendingManifest = voucherRef304;
        assemble();
    }

    private void assemble() {
        String paymentTag305 = this.pendingManifest;
        String refundCode306 = "ref:" + paymentTag305 + ";";
        String shipmentCode307 = refundCode306;
        cachedManifest = shipmentCode307;
        merge();
    }

    private void merge() {
        String manifestKey308 = cachedManifest;
        String invoiceKey309 = "ref:" + manifestKey308 + ";";
        Map<String, String> batchTag310Attrs = new HashMap<String, String>();
        batchTag310Attrs.put("channel", "web");
        batchTag310Attrs.put("payload", invoiceKey309);
        String batchTag310 = batchTag310Attrs.get("payload");
        ManifestExecutor.reconcile(batchTag310);
    }
}
