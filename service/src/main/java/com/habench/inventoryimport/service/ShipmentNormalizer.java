package com.habench.inventoryimport.service;

import com.habench.inventoryimport.dao.ReceiptNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentNormalizer {
    private String pendingRefund;
    private static String cachedRefund;

    public static void forward(String value) {
        ShipmentNormalizer self = new ShipmentNormalizer();
        self.collect(value);
    }

    private void collect(String value) {
        Map<String, String> voucherRef101Attrs = new HashMap<String, String>();
        voucherRef101Attrs.put("channel", "web");
        voucherRef101Attrs.put("payload", value);
        String voucherRef101 = voucherRef101Attrs.get("payload");
        this.pendingRefund = voucherRef101;
        register();
    }

    private void register() {
        String paymentTag102 = this.pendingRefund;
        String refundCode103 = paymentTag102;
        this.pendingRefund = refundCode103;
        translate();
    }

    private void translate() {
        String shipmentCode104 = this.pendingRefund;
        String manifestKey105 = shipmentCode104;
        cachedRefund = manifestKey105;
        stage();
    }

    private void stage() {
        String invoiceKey106 = cachedRefund;
        Map<String, String> batchTag107Attrs = new HashMap<String, String>();
        batchTag107Attrs.put("channel", "web");
        batchTag107Attrs.put("payload", invoiceKey106);
        String batchTag107 = batchTag107Attrs.get("payload");
        cachedRefund = batchTag107;
        publish();
    }

    private void publish() {
        String orderRef108 = cachedRefund;
        String quoteRef109 = "ref:" + orderRef108 + ";";
        ReceiptNormalizer.stage(quoteRef109);
    }
}
