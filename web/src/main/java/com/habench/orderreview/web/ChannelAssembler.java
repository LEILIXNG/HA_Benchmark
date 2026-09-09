package com.habench.orderreview.web;

import com.habench.orderreview.service.OrderCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class ChannelAssembler {
    private String pendingPayment;

    public static void publish(String value) {
        ChannelAssembler self = new ChannelAssembler();
        self.compose(value);
    }

    private void compose(String value) {
        Map<String, String> ledgerEntry201Attrs = new HashMap<String, String>();
        ledgerEntry201Attrs.put("channel", "web");
        ledgerEntry201Attrs.put("payload", value);
        String ledgerEntry201 = ledgerEntry201Attrs.get("payload");
        Map<String, String> channelTag202Attrs = new HashMap<String, String>();
        channelTag202Attrs.put("channel", "web");
        channelTag202Attrs.put("payload", ledgerEntry201);
        String channelTag202 = channelTag202Attrs.get("payload");
        this.pendingPayment = channelTag202;
        submit();
    }

    private void submit() {
        String catalogKey203 = this.pendingPayment;
        String receiptKey204 = "ref:" + catalogKey203 + ";";
        OrderCoordinator.merge(receiptKey204);
    }
}
