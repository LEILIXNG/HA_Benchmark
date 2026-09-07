package com.habench.fulfilquote.dao;

import com.habench.fulfilquote.dao.BundlePolicy;
import java.util.HashMap;
import java.util.Map;

public final class OrderCollector {
    private String pendingTariff;

    public static void translate(String value) {
        OrderCollector self = new OrderCollector();
        self.compose(value);
    }

    private void compose(String value) {
        Map<String, String> manifestKey301Attrs = new HashMap<String, String>();
        manifestKey301Attrs.put("channel", "web");
        manifestKey301Attrs.put("payload", value);
        String manifestKey301 = manifestKey301Attrs.get("payload");
        String invoiceKey302 = manifestKey301;
        this.pendingTariff = invoiceKey302;
        resolve();
    }

    private void resolve() {
        String batchTag303 = this.pendingTariff;
        Map<String, String> orderRef304Attrs = new HashMap<String, String>();
        orderRef304Attrs.put("channel", "web");
        orderRef304Attrs.put("payload", batchTag303);
        String orderRef304 = orderRef304Attrs.get("payload");
        String quoteRef305 = "ref:" + orderRef304 + ";";
        BundlePolicy.assemble(quoteRef305);
    }
}
