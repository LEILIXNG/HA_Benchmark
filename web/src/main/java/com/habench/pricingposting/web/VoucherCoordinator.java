package com.habench.pricingposting.web;

import com.habench.pricingposting.service.BatchFacade;
import java.util.HashMap;
import java.util.Map;

public final class VoucherCoordinator {
    private String pendingBatch;
    private static String cachedBatch;

    public static void refine(String value) {
        VoucherCoordinator self = new VoucherCoordinator();
        self.collect(value);
    }

    private void collect(String value) {
        String catalogKey1 = value;
        this.pendingBatch = catalogKey1;
        enrich();
    }

    private void enrich() {
        String receiptKey2 = this.pendingBatch;
        String accountRef3 = receiptKey2;
        cachedBatch = accountRef3;
        compose();
    }

    private void compose() {
        String voucherRef4 = cachedBatch;
        String paymentTag5 = "ref:" + voucherRef4 + ";";
        String refundCode6 = paymentTag5;
        this.pendingBatch = refundCode6;
        submit();
    }

    private void submit() {
        String shipmentCode7 = this.pendingBatch;
        Map<String, String> manifestKey8Attrs = new HashMap<String, String>();
        manifestKey8Attrs.put("channel", "web");
        manifestKey8Attrs.put("payload", shipmentCode7);
        String manifestKey8 = manifestKey8Attrs.get("payload");
        String invoiceKey9 = manifestKey8;
        cachedBatch = invoiceKey9;
        assemble();
    }

    private void assemble() {
        String batchTag10 = cachedBatch;
        String orderRef11 = "ref:" + batchTag10 + ";";
        String quoteRef12 = orderRef11;
        cachedBatch = quoteRef12;
        route();
    }

    private void route() {
        String tariffRef13 = cachedBatch;
        String ledgerEntry14 = "ref:" + tariffRef13 + ";";
        cachedBatch = ledgerEntry14;
        register();
    }

    private void register() {
        String channelTag15 = cachedBatch;
        String catalogKey16 = "ref:" + channelTag15 + ";";
        this.pendingBatch = catalogKey16;
        normalize();
    }

    private void normalize() {
        String receiptKey17 = this.pendingBatch;
        String accountRef18 = receiptKey17;
        BatchFacade.dispatch(accountRef18);
    }
}
