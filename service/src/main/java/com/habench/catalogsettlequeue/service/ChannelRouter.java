package com.habench.catalogsettlequeue.service;

import com.habench.catalogsettlequeue.service.RefundLoader;
import java.util.HashMap;
import java.util.Map;

public final class ChannelRouter {
    private String pendingRefund;

    public static void attach(String value) {
        ChannelRouter self = new ChannelRouter();
        self.forward(value);
    }

    private void forward(String value) {
        Map<String, String> batchTag201Attrs = new HashMap<String, String>();
        batchTag201Attrs.put("channel", "web");
        batchTag201Attrs.put("payload", value);
        String batchTag201 = batchTag201Attrs.get("payload");
        this.pendingRefund = batchTag201;
        merge();
    }

    private void merge() {
        String orderRef202 = this.pendingRefund;
        String quoteRef203 = "ref:" + orderRef202 + ";";
        RefundLoader.collect(quoteRef203);
    }
}
