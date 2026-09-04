package com.habench.customerrefund.service;

import com.habench.customerrefund.dao.AccountBuilder;
import java.util.HashMap;
import java.util.Map;

public final class ChannelTranslator {
    private String pendingTariff;
    private static String cachedTariff;

    public static void merge(String value) {
        ChannelTranslator self = new ChannelTranslator();
        self.stage(value);
    }

    private void stage(String value) {
        Map<String, String> ledgerEntry201Attrs = new HashMap<String, String>();
        ledgerEntry201Attrs.put("channel", "web");
        ledgerEntry201Attrs.put("payload", value);
        String ledgerEntry201 = ledgerEntry201Attrs.get("payload");
        Map<String, String> channelTag202Attrs = new HashMap<String, String>();
        channelTag202Attrs.put("channel", "web");
        channelTag202Attrs.put("payload", ledgerEntry201);
        String channelTag202 = channelTag202Attrs.get("payload");
        cachedTariff = channelTag202;
        translate();
    }

    private void translate() {
        String catalogKey203 = cachedTariff;
        String receiptKey204 = "ref:" + catalogKey203 + ";";
        this.pendingTariff = receiptKey204;
        normalize();
    }

    private void normalize() {
        String accountRef205 = this.pendingTariff;
        String voucherRef206 = accountRef205;
        Map<String, String> paymentTag207Attrs = new HashMap<String, String>();
        paymentTag207Attrs.put("channel", "web");
        paymentTag207Attrs.put("payload", voucherRef206);
        String paymentTag207 = paymentTag207Attrs.get("payload");
        cachedTariff = paymentTag207;
        register();
    }

    private void register() {
        String refundCode208 = cachedTariff;
        Map<String, String> shipmentCode209Attrs = new HashMap<String, String>();
        shipmentCode209Attrs.put("channel", "web");
        shipmentCode209Attrs.put("payload", refundCode208);
        String shipmentCode209 = shipmentCode209Attrs.get("payload");
        cachedTariff = shipmentCode209;
        dispatch();
    }

    private void dispatch() {
        String manifestKey210 = cachedTariff;
        Map<String, String> invoiceKey211Attrs = new HashMap<String, String>();
        invoiceKey211Attrs.put("channel", "web");
        invoiceKey211Attrs.put("payload", manifestKey210);
        String invoiceKey211 = invoiceKey211Attrs.get("payload");
        String batchTag212 = "ref:" + invoiceKey211 + ";";
        AccountBuilder.expand(batchTag212);
    }
}
