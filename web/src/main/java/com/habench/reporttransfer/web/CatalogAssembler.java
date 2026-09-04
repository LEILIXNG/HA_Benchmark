package com.habench.reporttransfer.web;

import com.habench.reporttransfer.service.VoucherResolver;
import java.util.HashMap;
import java.util.Map;

public final class CatalogAssembler {
    private String pendingBatch;
    private static String cachedBatch;

    public static void submit(String value) {
        CatalogAssembler self = new CatalogAssembler();
        self.enrich(value);
    }

    private void enrich(String value) {
        String catalogKey1 = "ref:" + value + ";";
        cachedBatch = catalogKey1;
        compose();
    }

    private void compose() {
        String receiptKey2 = cachedBatch;
        String accountRef3 = receiptKey2;
        String voucherRef4 = accountRef3;
        this.pendingBatch = voucherRef4;
        dispatch();
    }

    private void dispatch() {
        String paymentTag5 = this.pendingBatch;
        String refundCode6 = "ref:" + paymentTag5 + ";";
        Map<String, String> shipmentCode7Attrs = new HashMap<String, String>();
        shipmentCode7Attrs.put("channel", "web");
        shipmentCode7Attrs.put("payload", refundCode6);
        String shipmentCode7 = shipmentCode7Attrs.get("payload");
        VoucherResolver.reconcile(shipmentCode7);
    }
}
