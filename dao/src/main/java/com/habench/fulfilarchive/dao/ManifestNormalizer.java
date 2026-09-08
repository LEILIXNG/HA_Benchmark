package com.habench.fulfilarchive.dao;

import com.habench.fulfilarchive.dao.RefundEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class ManifestNormalizer {
    private String pendingRefund;
    private static String cachedRefund;

    public static void publish(String value) {
        ManifestNormalizer self = new ManifestNormalizer();
        self.translate(value);
    }

    private void translate(String value) {
        Map<String, String> channelTag401Attrs = new HashMap<String, String>();
        channelTag401Attrs.put("channel", "web");
        channelTag401Attrs.put("payload", value);
        String channelTag401 = channelTag401Attrs.get("payload");
        String catalogKey402 = channelTag401;
        cachedRefund = catalogKey402;
        submit();
    }

    private void submit() {
        String receiptKey403 = cachedRefund;
        String accountRef404 = "ref:" + receiptKey403 + ";";
        String voucherRef405 = accountRef404;
        cachedRefund = voucherRef405;
        dispatch();
    }

    private void dispatch() {
        String paymentTag406 = cachedRefund;
        String refundCode407 = paymentTag406;
        this.pendingRefund = refundCode407;
        prepare();
    }

    private void prepare() {
        String shipmentCode408 = this.pendingRefund;
        Map<String, String> manifestKey409Attrs = new HashMap<String, String>();
        manifestKey409Attrs.put("channel", "web");
        manifestKey409Attrs.put("payload", shipmentCode408);
        String manifestKey409 = manifestKey409Attrs.get("payload");
        RefundEvaluator.submit(manifestKey409);
    }
}
