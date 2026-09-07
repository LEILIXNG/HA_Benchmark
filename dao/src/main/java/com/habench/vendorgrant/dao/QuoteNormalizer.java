package com.habench.vendorgrant.dao;

import com.habench.vendorgrant.dao.OrderExecutor;
import java.util.HashMap;
import java.util.Map;

public final class QuoteNormalizer {
    private String pendingOrder;

    public static void resolve(String value) {
        QuoteNormalizer self = new QuoteNormalizer();
        self.route(value);
    }

    private void route(String value) {
        Map<String, String> orderRef301Attrs = new HashMap<String, String>();
        orderRef301Attrs.put("channel", "web");
        orderRef301Attrs.put("payload", value);
        String orderRef301 = orderRef301Attrs.get("payload");
        this.pendingOrder = orderRef301;
        prepare();
    }

    private void prepare() {
        String quoteRef302 = this.pendingOrder;
        String tariffRef303 = "ref:" + quoteRef302 + ";";
        OrderExecutor.forward(tariffRef303);
    }
}
