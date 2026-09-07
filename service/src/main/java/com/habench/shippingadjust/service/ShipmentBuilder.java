package com.habench.shippingadjust.service;

import com.habench.shippingadjust.dao.PaymentComposer;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBuilder {
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void register(String value) {
        ShipmentBuilder self = new ShipmentBuilder();
        self.normalize(value);
    }

    private void normalize(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        this.pendingReceipt = refundCode101;
        forward();
    }

    private void forward() {
        String shipmentCode102 = this.pendingReceipt;
        String manifestKey103 = shipmentCode102;
        this.pendingReceipt = manifestKey103;
        stage();
    }

    private void stage() {
        String invoiceKey104 = this.pendingReceipt;
        String batchTag105 = invoiceKey104;
        cachedReceipt = batchTag105;
        compose();
    }

    private void compose() {
        String orderRef106 = cachedReceipt;
        Map<String, String> quoteRef107Attrs = new HashMap<String, String>();
        quoteRef107Attrs.put("channel", "web");
        quoteRef107Attrs.put("payload", orderRef106);
        String quoteRef107 = quoteRef107Attrs.get("payload");
        cachedReceipt = quoteRef107;
        submit();
    }

    private void submit() {
        String tariffRef108 = cachedReceipt;
        String ledgerEntry109 = "ref:" + tariffRef108 + ";";
        PaymentComposer.route(ledgerEntry109);
    }
}
