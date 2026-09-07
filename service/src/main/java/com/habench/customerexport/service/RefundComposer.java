package com.habench.customerexport.service;

import com.habench.customerexport.service.ShipmentStrategySelector;

public final class RefundComposer {
    private String pendingVoucher;
    private static String cachedVoucher;

    public static void reconcile(String value) {
        RefundComposer self = new RefundComposer();
        self.enrich(value);
    }

    private void enrich(String value) {
        String shipmentCode101 = value;
        String manifestKey102 = shipmentCode101;
        cachedVoucher = manifestKey102;
        publish();
    }

    private void publish() {
        String invoiceKey103 = cachedVoucher;
        String batchTag104 = invoiceKey103;
        this.pendingVoucher = batchTag104;
        collect();
    }

    private void collect() {
        String orderRef105 = this.pendingVoucher;
        String quoteRef106 = orderRef105;
        cachedVoucher = quoteRef106;
        dispatch();
    }

    private void dispatch() {
        String tariffRef107 = cachedVoucher;
        String ledgerEntry108 = tariffRef107;
        String channelTag109 = "ref:" + ledgerEntry108 + ";";
        cachedVoucher = channelTag109;
        refine();
    }

    private void refine() {
        String catalogKey110 = cachedVoucher;
        String receiptKey111 = "ref:" + catalogKey110 + ";";
        String accountRef112 = receiptKey111;
        ShipmentStrategySelector.route(accountRef112);
    }
}
