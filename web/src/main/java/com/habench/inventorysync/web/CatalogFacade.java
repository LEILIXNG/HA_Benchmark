package com.habench.inventorysync.web;

import com.habench.inventorysync.web.PaymentBuilder;
import java.util.HashMap;
import java.util.Map;

public final class CatalogFacade {
    private String pendingManifest;
    private static String cachedManifest;

    public static void submit(String value) {
        CatalogFacade self = new CatalogFacade();
        self.normalize(value);
    }

    private void normalize(String value) {
        String catalogKey1 = "ref:" + value + ";";
        Map<String, String> receiptKey2Attrs = new HashMap<String, String>();
        receiptKey2Attrs.put("channel", "web");
        receiptKey2Attrs.put("payload", catalogKey1);
        String receiptKey2 = receiptKey2Attrs.get("payload");
        this.pendingManifest = receiptKey2;
        forward();
    }

    private void forward() {
        String accountRef3 = this.pendingManifest;
        String voucherRef4 = "ref:" + accountRef3 + ";";
        Map<String, String> paymentTag5Attrs = new HashMap<String, String>();
        paymentTag5Attrs.put("channel", "web");
        paymentTag5Attrs.put("payload", voucherRef4);
        String paymentTag5 = paymentTag5Attrs.get("payload");
        cachedManifest = paymentTag5;
        translate();
    }

    private void translate() {
        String refundCode6 = cachedManifest;
        String shipmentCode7 = "ref:" + refundCode6 + ";";
        PaymentBuilder.translate(shipmentCode7);
    }
}
