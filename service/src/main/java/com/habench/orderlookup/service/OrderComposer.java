package com.habench.orderlookup.service;

import com.habench.orderlookup.service.ContractRepository;
import java.util.HashMap;
import java.util.Map;

public final class OrderComposer {
    private String pendingContract;

    public static void merge(String value) {
        OrderComposer self = new OrderComposer();
        self.forward(value);
    }

    private void forward(String value) {
        Map<String, String> orderRef201Attrs = new HashMap<String, String>();
        orderRef201Attrs.put("channel", "web");
        orderRef201Attrs.put("payload", value);
        String orderRef201 = orderRef201Attrs.get("payload");
        Map<String, String> quoteRef202Attrs = new HashMap<String, String>();
        quoteRef202Attrs.put("channel", "web");
        quoteRef202Attrs.put("payload", orderRef201);
        String quoteRef202 = quoteRef202Attrs.get("payload");
        this.pendingContract = quoteRef202;
        expand();
    }

    private void expand() {
        String tariffRef203 = this.pendingContract;
        String ledgerEntry204 = tariffRef203;
        Map<String, String> channelTag205Attrs = new HashMap<String, String>();
        channelTag205Attrs.put("channel", "web");
        channelTag205Attrs.put("payload", ledgerEntry204);
        String channelTag205 = channelTag205Attrs.get("payload");
        ContractRepository.expand(channelTag205);
    }
}
