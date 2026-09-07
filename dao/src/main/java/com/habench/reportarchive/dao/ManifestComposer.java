package com.habench.reportarchive.dao;

import com.habench.reportarchive.dao.QuoteStrategySelector;

public final class ManifestComposer {
    private String pendingSession;
    private static String cachedSession;

    public static void collect(String value) {
        ManifestComposer self = new ManifestComposer();
        self.submit(value);
    }

    private void submit(String value) {
        String accountRef301 = value;
        String voucherRef302 = "ref:" + accountRef301 + ";";
        this.pendingSession = voucherRef302;
        dispatch();
    }

    private void dispatch() {
        String paymentTag303 = this.pendingSession;
        String refundCode304 = "ref:" + paymentTag303 + ";";
        String shipmentCode305 = "ref:" + refundCode304 + ";";
        cachedSession = shipmentCode305;
        reconcile();
    }

    private void reconcile() {
        String manifestKey306 = cachedSession;
        String invoiceKey307 = manifestKey306;
        QuoteStrategySelector.compose(invoiceKey307);
    }
}
