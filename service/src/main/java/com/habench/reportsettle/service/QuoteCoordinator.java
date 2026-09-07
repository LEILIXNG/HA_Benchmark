package com.habench.reportsettle.service;

import com.habench.reportsettle.service.ChannelRepository;
import java.util.HashMap;
import java.util.Map;

public final class QuoteCoordinator {
    private String pendingChannel;
    private static String cachedChannel;

    public static void forward(String value) {
        QuoteCoordinator self = new QuoteCoordinator();
        self.attach(value);
    }

    private void attach(String value) {
        String orderRef201 = value;
        Map<String, String> quoteRef202Attrs = new HashMap<String, String>();
        quoteRef202Attrs.put("channel", "web");
        quoteRef202Attrs.put("payload", orderRef201);
        String quoteRef202 = quoteRef202Attrs.get("payload");
        cachedChannel = quoteRef202;
        route();
    }

    private void route() {
        String tariffRef203 = cachedChannel;
        Map<String, String> ledgerEntry204Attrs = new HashMap<String, String>();
        ledgerEntry204Attrs.put("channel", "web");
        ledgerEntry204Attrs.put("payload", tariffRef203);
        String ledgerEntry204 = ledgerEntry204Attrs.get("payload");
        String channelTag205 = "ref:" + ledgerEntry204 + ";";
        cachedChannel = channelTag205;
        translate();
    }

    private void translate() {
        String catalogKey206 = cachedChannel;
        String receiptKey207 = catalogKey206;
        this.pendingChannel = receiptKey207;
        refine();
    }

    private void refine() {
        String accountRef208 = this.pendingChannel;
        String voucherRef209 = "ref:" + accountRef208 + ";";
        Map<String, String> paymentTag210Attrs = new HashMap<String, String>();
        paymentTag210Attrs.put("channel", "web");
        paymentTag210Attrs.put("payload", voucherRef209);
        String paymentTag210 = paymentTag210Attrs.get("payload");
        ChannelRepository.translate(paymentTag210);
    }
}
