package com.habench.customerexport.web;

import com.habench.customerexport.service.ShipmentRouter;
import java.util.HashMap;
import java.util.Map;

public final class LedgerTranslator {
    private String pendingVoucher;
    private static String cachedVoucher;

    public static void assemble(String value) {
        LedgerTranslator self = new LedgerTranslator();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String voucherRef1 = "ref:" + value + ";";
        Map<String, String> paymentTag2Attrs = new HashMap<String, String>();
        paymentTag2Attrs.put("channel", "web");
        paymentTag2Attrs.put("payload", voucherRef1);
        String paymentTag2 = paymentTag2Attrs.get("payload");
        this.pendingVoucher = paymentTag2;
        collect();
    }

    private void collect() {
        String refundCode3 = this.pendingVoucher;
        String shipmentCode4 = refundCode3;
        this.pendingVoucher = shipmentCode4;
        forward();
    }

    private void forward() {
        String manifestKey5 = this.pendingVoucher;
        Map<String, String> invoiceKey6Attrs = new HashMap<String, String>();
        invoiceKey6Attrs.put("channel", "web");
        invoiceKey6Attrs.put("payload", manifestKey5);
        String invoiceKey6 = invoiceKey6Attrs.get("payload");
        Map<String, String> batchTag7Attrs = new HashMap<String, String>();
        batchTag7Attrs.put("channel", "web");
        batchTag7Attrs.put("payload", invoiceKey6);
        String batchTag7 = batchTag7Attrs.get("payload");
        this.pendingVoucher = batchTag7;
        submit();
    }

    private void submit() {
        String orderRef8 = this.pendingVoucher;
        Map<String, String> quoteRef9Attrs = new HashMap<String, String>();
        quoteRef9Attrs.put("channel", "web");
        quoteRef9Attrs.put("payload", orderRef8);
        String quoteRef9 = quoteRef9Attrs.get("payload");
        cachedVoucher = quoteRef9;
        refine();
    }

    private void refine() {
        String tariffRef10 = cachedVoucher;
        Map<String, String> ledgerEntry11Attrs = new HashMap<String, String>();
        ledgerEntry11Attrs.put("channel", "web");
        ledgerEntry11Attrs.put("payload", tariffRef10);
        String ledgerEntry11 = ledgerEntry11Attrs.get("payload");
        String channelTag12 = "ref:" + ledgerEntry11 + ";";
        ShipmentRouter.publish(channelTag12);
    }
}
