package com.habench.shippingledger.service;

import com.habench.shippingledger.service.RefundValidator;
import java.util.HashMap;
import java.util.Map;

public final class ChannelCollector {
    private String pendingBatch;
    private static String cachedBatch;

    public static void submit(String value) {
        ChannelCollector self = new ChannelCollector();
        self.route(value);
    }

    private void route(String value) {
        String quoteRef301 = "ref:" + value + ";";
        Map<String, String> tariffRef302Attrs = new HashMap<String, String>();
        tariffRef302Attrs.put("channel", "web");
        tariffRef302Attrs.put("payload", quoteRef301);
        String tariffRef302 = tariffRef302Attrs.get("payload");
        cachedBatch = tariffRef302;
        resolve();
    }

    private void resolve() {
        String ledgerEntry303 = cachedBatch;
        Map<String, String> channelTag304Attrs = new HashMap<String, String>();
        channelTag304Attrs.put("channel", "web");
        channelTag304Attrs.put("payload", ledgerEntry303);
        String channelTag304 = channelTag304Attrs.get("payload");
        Map<String, String> catalogKey305Attrs = new HashMap<String, String>();
        catalogKey305Attrs.put("channel", "web");
        catalogKey305Attrs.put("payload", channelTag304);
        String catalogKey305 = catalogKey305Attrs.get("payload");
        this.pendingBatch = catalogKey305;
        normalize();
    }

    private void normalize() {
        String receiptKey306 = this.pendingBatch;
        String accountRef307 = "ref:" + receiptKey306 + ";";
        this.pendingBatch = accountRef307;
        publish();
    }

    private void publish() {
        String voucherRef308 = this.pendingBatch;
        String paymentTag309 = "ref:" + voucherRef308 + ";";
        RefundValidator.route(paymentTag309);
    }
}
