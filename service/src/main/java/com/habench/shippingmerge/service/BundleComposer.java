package com.habench.shippingmerge.service;

import com.habench.shippingmerge.dao.SessionBuilder;
import java.util.HashMap;
import java.util.Map;

public final class BundleComposer {
    private static String cachedAccount;

    public static void assemble(String value) {
        String paymentTag201 = "ref:" + value + ";";
        String refundCode202 = paymentTag201;
        cachedAccount = refundCode202;
        forward();
    }

    private static void forward() {
        String shipmentCode203 = cachedAccount;
        String manifestKey204 = "ref:" + shipmentCode203 + ";";
        String invoiceKey205 = "ref:" + manifestKey204 + ";";
        cachedAccount = invoiceKey205;
        submit();
    }

    private static void submit() {
        String batchTag206 = cachedAccount;
        Map<String, String> orderRef207Attrs = new HashMap<String, String>();
        orderRef207Attrs.put("channel", "web");
        orderRef207Attrs.put("payload", batchTag206);
        String orderRef207 = orderRef207Attrs.get("payload");
        cachedAccount = orderRef207;
        expand();
    }

    private static void expand() {
        String quoteRef208 = cachedAccount;
        String tariffRef209 = quoteRef208;
        Map<String, String> ledgerEntry210Attrs = new HashMap<String, String>();
        ledgerEntry210Attrs.put("channel", "web");
        ledgerEntry210Attrs.put("payload", tariffRef209);
        String ledgerEntry210 = ledgerEntry210Attrs.get("payload");
        cachedAccount = ledgerEntry210;
        dispatch();
    }

    private static void dispatch() {
        String channelTag211 = cachedAccount;
        String catalogKey212 = channelTag211;
        cachedAccount = catalogKey212;
        register();
    }

    private static void register() {
        String receiptKey213 = cachedAccount;
        String accountRef214 = receiptKey213;
        String voucherRef215 = "ref:" + accountRef214 + ";";
        SessionBuilder.normalize(voucherRef215);
    }
}
