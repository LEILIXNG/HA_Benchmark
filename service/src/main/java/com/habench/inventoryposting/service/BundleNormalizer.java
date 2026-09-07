package com.habench.inventoryposting.service;

import com.habench.inventoryposting.service.ShipmentPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class BundleNormalizer {
    private String pendingContract;
    private static String cachedContract;

    public static void forward(String value) {
        BundleNormalizer self = new BundleNormalizer();
        self.prepare(value);
    }

    private void prepare(String value) {
        String channelTag101 = "ref:" + value + ";";
        String catalogKey102 = "ref:" + channelTag101 + ";";
        cachedContract = catalogKey102;
        submit();
    }

    private void submit() {
        String receiptKey103 = cachedContract;
        Map<String, String> accountRef104Attrs = new HashMap<String, String>();
        accountRef104Attrs.put("channel", "web");
        accountRef104Attrs.put("payload", receiptKey103);
        String accountRef104 = accountRef104Attrs.get("payload");
        String voucherRef105 = accountRef104;
        cachedContract = voucherRef105;
        compose();
    }

    private void compose() {
        String paymentTag106 = cachedContract;
        Map<String, String> refundCode107Attrs = new HashMap<String, String>();
        refundCode107Attrs.put("channel", "web");
        refundCode107Attrs.put("payload", paymentTag106);
        String refundCode107 = refundCode107Attrs.get("payload");
        String shipmentCode108 = "ref:" + refundCode107 + ";";
        cachedContract = shipmentCode108;
        expand();
    }

    private void expand() {
        String manifestKey109 = cachedContract;
        String invoiceKey110 = "ref:" + manifestKey109 + ";";
        this.pendingContract = invoiceKey110;
        translate();
    }

    private void translate() {
        String batchTag111 = this.pendingContract;
        String orderRef112 = batchTag111;
        String quoteRef113 = orderRef112;
        this.pendingContract = quoteRef113;
        normalize();
    }

    private void normalize() {
        String tariffRef114 = this.pendingContract;
        String ledgerEntry115 = "ref:" + tariffRef114 + ";";
        ShipmentPlanSelector.compose(ledgerEntry115);
    }
}
