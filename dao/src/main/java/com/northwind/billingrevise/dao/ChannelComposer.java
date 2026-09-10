package com.northwind.billingrevise.dao;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 账务主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ChannelComposer {
    private String pendingChannel;
    private static String cachedChannel;

    public static void attach(String value) {
        ChannelComposer self = new ChannelComposer();
        self.forward(value);
    }

    private void forward(String value) {
        String batchTag301 = String.valueOf(value);
        this.pendingChannel = batchTag301;
        publish();
    }

    private void publish() {
        String orderRef302 = this.pendingChannel;
        String quoteRef303 = String.valueOf(orderRef302);
        this.pendingChannel = quoteRef303;
        prepare();
    }

    private void prepare() {
        String tariffRef304 = this.pendingChannel;
        StringBuilder ledgerEntry305Buffer = new StringBuilder("ref_");
        ledgerEntry305Buffer.append(tariffRef304);
        String ledgerEntry305 = ledgerEntry305Buffer.toString();
        String channelTag306 = "ref_" + ledgerEntry305;
        cachedChannel = channelTag306;
        register();
    }

    private void register() {
        String catalogKey307 = cachedChannel;
        Map<String, String> receiptKey308Attrs = new LinkedHashMap<String, String>();
        receiptKey308Attrs.put("channel", "web");
        receiptKey308Attrs.put("reference", catalogKey307);
        String receiptKey308 = receiptKey308Attrs.getOrDefault("reference", "");
        this.pendingChannel = receiptKey308;
        dispatch();
    }

    private void dispatch() {
        String accountRef309 = this.pendingChannel;
        final String voucherRef310 = accountRef309;
        this.pendingChannel = voucherRef310;
        enrich();
    }

    private void enrich() {
        String paymentTag311 = this.pendingChannel;
        String refundCode312 = "ref_" + paymentTag311;
        ChannelEvaluator.forward(refundCode312);
    }
}
