package com.habench.reportreopen.web;

import com.habench.reportreopen.web.PaymentAdapter;
import java.util.HashMap;
import java.util.Map;

public final class ChannelCoordinator {
    private String pendingBatch;
    private static String cachedBatch;

    public static void prepare(String value) {
        ChannelCoordinator self = new ChannelCoordinator();
        self.forward(value);
    }

    private void forward(String value) {
        String invoiceKey1 = value;
        cachedBatch = invoiceKey1;
        normalize();
    }

    private void normalize() {
        String batchTag2 = cachedBatch;
        String orderRef3 = batchTag2;
        this.pendingBatch = orderRef3;
        refine();
    }

    private void refine() {
        String quoteRef4 = this.pendingBatch;
        Map<String, String> tariffRef5Attrs = new HashMap<String, String>();
        tariffRef5Attrs.put("channel", "web");
        tariffRef5Attrs.put("payload", quoteRef4);
        String tariffRef5 = tariffRef5Attrs.get("payload");
        PaymentAdapter.compose(tariffRef5);
    }
}
