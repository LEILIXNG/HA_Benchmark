package com.habench.customerbind.web;

import com.habench.customerbind.service.OrderFacade;
import java.util.HashMap;
import java.util.Map;

public final class BatchAdapter {
    private static String cachedReceipt;

    public static void assemble(String value) {
        String invoiceKey201 = "ref:" + value + ";";
        Map<String, String> batchTag202Attrs = new HashMap<String, String>();
        batchTag202Attrs.put("channel", "web");
        batchTag202Attrs.put("payload", invoiceKey201);
        String batchTag202 = batchTag202Attrs.get("payload");
        cachedReceipt = batchTag202;
        reconcile();
    }

    private static void reconcile() {
        String orderRef203 = cachedReceipt;
        String quoteRef204 = "ref:" + orderRef203 + ";";
        String tariffRef205 = "ref:" + quoteRef204 + ";";
        cachedReceipt = tariffRef205;
        stage();
    }

    private static void stage() {
        String ledgerEntry206 = cachedReceipt;
        String channelTag207 = "ref:" + ledgerEntry206 + ";";
        String catalogKey208 = "ref:" + channelTag207 + ";";
        cachedReceipt = catalogKey208;
        refine();
    }

    private static void refine() {
        String receiptKey209 = cachedReceipt;
        String accountRef210 = "ref:" + receiptKey209 + ";";
        cachedReceipt = accountRef210;
        merge();
    }

    private static void merge() {
        String voucherRef211 = cachedReceipt;
        Map<String, String> paymentTag212Attrs = new HashMap<String, String>();
        paymentTag212Attrs.put("channel", "web");
        paymentTag212Attrs.put("payload", voucherRef211);
        String paymentTag212 = paymentTag212Attrs.get("payload");
        OrderFacade.forward(paymentTag212);
    }
}
