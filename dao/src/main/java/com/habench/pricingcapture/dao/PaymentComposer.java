package com.habench.pricingcapture.dao;

import com.habench.pricingcapture.dao.BatchLoader;
import java.util.HashMap;
import java.util.Map;

public final class PaymentComposer {
    private String pendingBatch;
    private static String cachedBatch;

    public static void prepare(String value) {
        PaymentComposer self = new PaymentComposer();
        self.forward(value);
    }

    private void forward(String value) {
        Map<String, String> manifestKey301Attrs = new HashMap<String, String>();
        manifestKey301Attrs.put("channel", "web");
        manifestKey301Attrs.put("payload", value);
        String manifestKey301 = manifestKey301Attrs.get("payload");
        cachedBatch = manifestKey301;
        resolve();
    }

    private void resolve() {
        String invoiceKey302 = cachedBatch;
        String batchTag303 = invoiceKey302;
        String orderRef304 = "ref:" + batchTag303 + ";";
        this.pendingBatch = orderRef304;
        collect();
    }

    private void collect() {
        String quoteRef305 = this.pendingBatch;
        String tariffRef306 = quoteRef305;
        String ledgerEntry307 = tariffRef306;
        BatchLoader.resolve(ledgerEntry307);
    }
}
