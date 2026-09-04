package com.habench.paymentledger.service;

import com.habench.paymentledger.dao.VoucherComposer;
import java.util.HashMap;
import java.util.Map;

public final class LedgerRegistry {
    private String pendingOrder;
    private static String cachedOrder;

    public static void refine(String value) {
        LedgerRegistry self = new LedgerRegistry();
        self.forward(value);
    }

    private void forward(String value) {
        String voucherRef101 = "ref:" + value + ";";
        cachedOrder = voucherRef101;
        prepare();
    }

    private void prepare() {
        String paymentTag102 = cachedOrder;
        String refundCode103 = paymentTag102;
        String shipmentCode104 = "ref:" + refundCode103 + ";";
        cachedOrder = shipmentCode104;
        translate();
    }

    private void translate() {
        String manifestKey105 = cachedOrder;
        Map<String, String> invoiceKey106Attrs = new HashMap<String, String>();
        invoiceKey106Attrs.put("channel", "web");
        invoiceKey106Attrs.put("payload", manifestKey105);
        String invoiceKey106 = invoiceKey106Attrs.get("payload");
        Map<String, String> batchTag107Attrs = new HashMap<String, String>();
        batchTag107Attrs.put("channel", "web");
        batchTag107Attrs.put("payload", invoiceKey106);
        String batchTag107 = batchTag107Attrs.get("payload");
        this.pendingOrder = batchTag107;
        stage();
    }

    private void stage() {
        String orderRef108 = this.pendingOrder;
        String quoteRef109 = "ref:" + orderRef108 + ";";
        this.pendingOrder = quoteRef109;
        enrich();
    }

    private void enrich() {
        String tariffRef110 = this.pendingOrder;
        String ledgerEntry111 = "ref:" + tariffRef110 + ";";
        String channelTag112 = ledgerEntry111;
        VoucherComposer.forward(channelTag112);
    }
}
