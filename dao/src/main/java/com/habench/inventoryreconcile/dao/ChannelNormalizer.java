package com.habench.inventoryreconcile.dao;

import com.habench.inventoryreconcile.dao.SessionPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class ChannelNormalizer {
    private String pendingManifest;
    private static String cachedManifest;

    public static void normalize(String value) {
        ChannelNormalizer self = new ChannelNormalizer();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String manifestKey401 = "ref:" + value + ";";
        String invoiceKey402 = "ref:" + manifestKey401 + ";";
        cachedManifest = invoiceKey402;
        prepare();
    }

    private void prepare() {
        String batchTag403 = cachedManifest;
        String orderRef404 = "ref:" + batchTag403 + ";";
        Map<String, String> quoteRef405Attrs = new HashMap<String, String>();
        quoteRef405Attrs.put("channel", "web");
        quoteRef405Attrs.put("payload", orderRef404);
        String quoteRef405 = quoteRef405Attrs.get("payload");
        cachedManifest = quoteRef405;
        compose();
    }

    private void compose() {
        String tariffRef406 = cachedManifest;
        String ledgerEntry407 = "ref:" + tariffRef406 + ";";
        String channelTag408 = "ref:" + ledgerEntry407 + ";";
        this.pendingManifest = channelTag408;
        forward();
    }

    private void forward() {
        String catalogKey409 = this.pendingManifest;
        String receiptKey410 = catalogKey409;
        String accountRef411 = receiptKey410;
        this.pendingManifest = accountRef411;
        resolve();
    }

    private void resolve() {
        String voucherRef412 = this.pendingManifest;
        String paymentTag413 = "ref:" + voucherRef412 + ";";
        String refundCode414 = paymentTag413;
        SessionPlanSelector.stage(refundCode414);
    }
}
