package com.habench.accountexport.service;

import com.habench.accountexport.service.LedgerService;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceAdapter {
    private String pendingPayment;
    private static String cachedPayment;

    public static void resolve(String value) {
        InvoiceAdapter self = new InvoiceAdapter();
        self.prepare(value);
    }

    private void prepare(String value) {
        String invoiceKey101 = "ref:" + value + ";";
        String batchTag102 = "ref:" + invoiceKey101 + ";";
        this.pendingPayment = batchTag102;
        route();
    }

    private void route() {
        String orderRef103 = this.pendingPayment;
        String quoteRef104 = "ref:" + orderRef103 + ";";
        Map<String, String> tariffRef105Attrs = new HashMap<String, String>();
        tariffRef105Attrs.put("channel", "web");
        tariffRef105Attrs.put("payload", quoteRef104);
        String tariffRef105 = tariffRef105Attrs.get("payload");
        this.pendingPayment = tariffRef105;
        translate();
    }

    private void translate() {
        String ledgerEntry106 = this.pendingPayment;
        String channelTag107 = ledgerEntry106;
        String catalogKey108 = channelTag107;
        cachedPayment = catalogKey108;
        merge();
    }

    private void merge() {
        String receiptKey109 = cachedPayment;
        Map<String, String> accountRef110Attrs = new HashMap<String, String>();
        accountRef110Attrs.put("channel", "web");
        accountRef110Attrs.put("payload", receiptKey109);
        String accountRef110 = accountRef110Attrs.get("payload");
        String voucherRef111 = "ref:" + accountRef110 + ";";
        cachedPayment = voucherRef111;
        forward();
    }

    private void forward() {
        String paymentTag112 = cachedPayment;
        String refundCode113 = "ref:" + paymentTag112 + ";";
        cachedPayment = refundCode113;
        reconcile();
    }

    private void reconcile() {
        String shipmentCode114 = cachedPayment;
        String manifestKey115 = "ref:" + shipmentCode114 + ";";
        LedgerService.register(manifestKey115);
    }
}
