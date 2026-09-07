package com.habench.billingrevise.dao;

import com.habench.billingrevise.dao.ChannelEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class ChannelComposer {
    private String pendingChannel;
    private static String cachedChannel;

    public static void attach(String value) {
        ChannelComposer self = new ChannelComposer();
        self.forward(value);
    }

    private void forward(String value) {
        String batchTag301 = value;
        this.pendingChannel = batchTag301;
        publish();
    }

    private void publish() {
        String orderRef302 = this.pendingChannel;
        String quoteRef303 = orderRef302;
        this.pendingChannel = quoteRef303;
        prepare();
    }

    private void prepare() {
        String tariffRef304 = this.pendingChannel;
        String ledgerEntry305 = "ref:" + tariffRef304 + ";";
        String channelTag306 = "ref:" + ledgerEntry305 + ";";
        cachedChannel = channelTag306;
        register();
    }

    private void register() {
        String catalogKey307 = cachedChannel;
        Map<String, String> receiptKey308Attrs = new HashMap<String, String>();
        receiptKey308Attrs.put("channel", "web");
        receiptKey308Attrs.put("payload", catalogKey307);
        String receiptKey308 = receiptKey308Attrs.get("payload");
        this.pendingChannel = receiptKey308;
        dispatch();
    }

    private void dispatch() {
        String accountRef309 = this.pendingChannel;
        String voucherRef310 = accountRef309;
        this.pendingChannel = voucherRef310;
        enrich();
    }

    private void enrich() {
        String paymentTag311 = this.pendingChannel;
        String refundCode312 = "ref:" + paymentTag311 + ";";
        ChannelEvaluator.forward(refundCode312);
    }
}
