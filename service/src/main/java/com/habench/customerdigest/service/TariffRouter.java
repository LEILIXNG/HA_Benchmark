package com.habench.customerdigest.service;

import com.habench.customerdigest.dao.OrderComposer;
import java.util.HashMap;
import java.util.Map;

public final class TariffRouter {
    private String pendingBatch;

    public static void dispatch(String value) {
        TariffRouter self = new TariffRouter();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        Map<String, String> channelTag201Attrs = new HashMap<String, String>();
        channelTag201Attrs.put("channel", "web");
        channelTag201Attrs.put("payload", value);
        String channelTag201 = channelTag201Attrs.get("payload");
        this.pendingBatch = channelTag201;
        prepare();
    }

    private void prepare() {
        String catalogKey202 = this.pendingBatch;
        String receiptKey203 = "ref:" + catalogKey202 + ";";
        String accountRef204 = "ref:" + receiptKey203 + ";";
        OrderComposer.stage(accountRef204);
    }
}
