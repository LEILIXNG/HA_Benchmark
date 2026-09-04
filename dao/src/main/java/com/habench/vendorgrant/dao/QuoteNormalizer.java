package com.habench.vendorgrant.dao;

import com.habench.vendorgrant.dao.OrderExecutor;
import java.util.HashMap;
import java.util.Map;

public final class QuoteNormalizer {
    private String pendingOrder;
    private static String cachedOrder;

    public static void translate(String value) {
        QuoteNormalizer self = new QuoteNormalizer();
        self.route(value);
    }

    private void route(String value) {
        String paymentTag401 = value;
        cachedOrder = paymentTag401;
        prepare();
    }

    private void prepare() {
        String refundCode402 = cachedOrder;
        String shipmentCode403 = "ref:" + refundCode402 + ";";
        Map<String, String> manifestKey404Attrs = new HashMap<String, String>();
        manifestKey404Attrs.put("channel", "web");
        manifestKey404Attrs.put("payload", shipmentCode403);
        String manifestKey404 = manifestKey404Attrs.get("payload");
        this.pendingOrder = manifestKey404;
        resolve();
    }

    private void resolve() {
        String invoiceKey405 = this.pendingOrder;
        Map<String, String> batchTag406Attrs = new HashMap<String, String>();
        batchTag406Attrs.put("channel", "web");
        batchTag406Attrs.put("payload", invoiceKey405);
        String batchTag406 = batchTag406Attrs.get("payload");
        OrderExecutor.forward(batchTag406);
    }
}
