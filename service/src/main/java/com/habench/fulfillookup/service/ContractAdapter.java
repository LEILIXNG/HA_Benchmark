package com.habench.fulfillookup.service;

import com.habench.fulfillookup.dao.TariffResolver;
import java.util.HashMap;
import java.util.Map;

public final class ContractAdapter {
    private String pendingPayment;
    private static String cachedPayment;

    public static void refine(String value) {
        ContractAdapter self = new ContractAdapter();
        self.prepare(value);
    }

    private void prepare(String value) {
        String voucherRef101 = "ref:" + value + ";";
        this.pendingPayment = voucherRef101;
        reconcile();
    }

    private void reconcile() {
        String paymentTag102 = this.pendingPayment;
        String refundCode103 = paymentTag102;
        cachedPayment = refundCode103;
        resolve();
    }

    private void resolve() {
        String shipmentCode104 = cachedPayment;
        String manifestKey105 = "ref:" + shipmentCode104 + ";";
        Map<String, String> invoiceKey106Attrs = new HashMap<String, String>();
        invoiceKey106Attrs.put("channel", "web");
        invoiceKey106Attrs.put("payload", manifestKey105);
        String invoiceKey106 = invoiceKey106Attrs.get("payload");
        cachedPayment = invoiceKey106;
        enrich();
    }

    private void enrich() {
        String batchTag107 = cachedPayment;
        String orderRef108 = batchTag107;
        String quoteRef109 = orderRef108;
        this.pendingPayment = quoteRef109;
        collect();
    }

    private void collect() {
        String tariffRef110 = this.pendingPayment;
        String ledgerEntry111 = "ref:" + tariffRef110 + ";";
        TariffResolver.route(ledgerEntry111);
    }
}
