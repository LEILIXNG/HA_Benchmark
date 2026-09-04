package com.habench.paymentlookup.service;

import com.habench.paymentlookup.service.PaymentValidator;
import java.util.HashMap;
import java.util.Map;

public final class ChannelBroker {
    private String pendingChannel;

    public static void collect(String value) {
        ChannelBroker self = new ChannelBroker();
        self.publish(value);
    }

    private void publish(String value) {
        Map<String, String> tariffRef201Attrs = new HashMap<String, String>();
        tariffRef201Attrs.put("channel", "web");
        tariffRef201Attrs.put("payload", value);
        String tariffRef201 = tariffRef201Attrs.get("payload");
        Map<String, String> ledgerEntry202Attrs = new HashMap<String, String>();
        ledgerEntry202Attrs.put("channel", "web");
        ledgerEntry202Attrs.put("payload", tariffRef201);
        String ledgerEntry202 = ledgerEntry202Attrs.get("payload");
        this.pendingChannel = ledgerEntry202;
        submit();
    }

    private void submit() {
        String channelTag203 = this.pendingChannel;
        String catalogKey204 = channelTag203;
        Map<String, String> receiptKey205Attrs = new HashMap<String, String>();
        receiptKey205Attrs.put("channel", "web");
        receiptKey205Attrs.put("payload", catalogKey204);
        String receiptKey205 = receiptKey205Attrs.get("payload");
        PaymentValidator.route(receiptKey205);
    }
}
