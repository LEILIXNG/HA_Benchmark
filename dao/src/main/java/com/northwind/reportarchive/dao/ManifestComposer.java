package com.northwind.reportarchive.dao;

/**
 * 报表明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class ManifestComposer {
    private String pendingSession;
    private static String cachedSession;

    public static void collect(String value) {
        ManifestComposer self = new ManifestComposer();
        self.submit(value);
    }

    private void submit(String value) {
        String accountRef301 = value;
        String voucherRef302 = "ref_".concat(accountRef301);
        this.pendingSession = voucherRef302;
        dispatch();
    }

    private void dispatch() {
        String paymentTag303 = this.pendingSession;
        StringBuilder refundCode304Buffer = new StringBuilder("ref_");
        refundCode304Buffer.append(paymentTag303);
        String refundCode304 = refundCode304Buffer.toString();
        String shipmentCode305 = "ref_" + refundCode304;
        cachedSession = shipmentCode305;
        reconcile();
    }

    private void reconcile() {
        String manifestKey306 = cachedSession;
        final String invoiceKey307 = manifestKey306;
        QuoteStrategySelector.compose(invoiceKey307);
    }
}
