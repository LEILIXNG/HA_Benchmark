package com.habench.customerassign.dao;

import com.habench.customerassign.dao.LedgerStrategySelector;

public final class BundleNormalizer {
    private String pendingBundle;
    private static String cachedBundle;

    public static void translate(String value) {
        BundleNormalizer self = new BundleNormalizer();
        self.compose(value);
    }

    private void compose(String value) {
        String voucherRef201 = value;
        String paymentTag202 = "ref:" + voucherRef201 + ";";
        this.pendingBundle = paymentTag202;
        refine();
    }

    private void refine() {
        String refundCode203 = this.pendingBundle;
        String shipmentCode204 = "ref:" + refundCode203 + ";";
        cachedBundle = shipmentCode204;
        submit();
    }

    private void submit() {
        String manifestKey205 = cachedBundle;
        String invoiceKey206 = manifestKey205;
        cachedBundle = invoiceKey206;
        prepare();
    }

    private void prepare() {
        String batchTag207 = cachedBundle;
        String orderRef208 = "ref:" + batchTag207 + ";";
        this.pendingBundle = orderRef208;
        forward();
    }

    private void forward() {
        String quoteRef209 = this.pendingBundle;
        String tariffRef210 = "ref:" + quoteRef209 + ";";
        String ledgerEntry211 = "ref:" + tariffRef210 + ";";
        LedgerStrategySelector.expand(ledgerEntry211);
    }
}
