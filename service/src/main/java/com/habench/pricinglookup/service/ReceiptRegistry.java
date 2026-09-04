package com.habench.pricinglookup.service;

import com.habench.pricinglookup.service.ManifestRepository;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptRegistry {
    private String pendingManifest;
    private static String cachedManifest;

    public static void expand(String value) {
        ReceiptRegistry self = new ReceiptRegistry();
        self.assemble(value);
    }

    private void assemble(String value) {
        Map<String, String> catalogKey201Attrs = new HashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("payload", value);
        String catalogKey201 = catalogKey201Attrs.get("payload");
        Map<String, String> receiptKey202Attrs = new HashMap<String, String>();
        receiptKey202Attrs.put("channel", "web");
        receiptKey202Attrs.put("payload", catalogKey201);
        String receiptKey202 = receiptKey202Attrs.get("payload");
        cachedManifest = receiptKey202;
        resolve();
    }

    private void resolve() {
        String accountRef203 = cachedManifest;
        Map<String, String> voucherRef204Attrs = new HashMap<String, String>();
        voucherRef204Attrs.put("channel", "web");
        voucherRef204Attrs.put("payload", accountRef203);
        String voucherRef204 = voucherRef204Attrs.get("payload");
        this.pendingManifest = voucherRef204;
        merge();
    }

    private void merge() {
        String paymentTag205 = this.pendingManifest;
        Map<String, String> refundCode206Attrs = new HashMap<String, String>();
        refundCode206Attrs.put("channel", "web");
        refundCode206Attrs.put("payload", paymentTag205);
        String refundCode206 = refundCode206Attrs.get("payload");
        ManifestRepository.expand(refundCode206);
    }
}
