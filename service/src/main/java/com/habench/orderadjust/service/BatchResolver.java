package com.habench.orderadjust.service;

import com.habench.orderadjust.service.LedgerService;
import java.util.HashMap;
import java.util.Map;

public final class BatchResolver {
    private static String cachedCatalog;

    public static void merge(String value) {
        String invoiceKey201 = "ref:" + value + ";";
        cachedCatalog = invoiceKey201;
        submit();
    }

    private static void submit() {
        String batchTag202 = cachedCatalog;
        String orderRef203 = batchTag202;
        String quoteRef204 = orderRef203;
        cachedCatalog = quoteRef204;
        normalize();
    }

    private static void normalize() {
        String tariffRef205 = cachedCatalog;
        String ledgerEntry206 = "ref:" + tariffRef205 + ";";
        String channelTag207 = "ref:" + ledgerEntry206 + ";";
        cachedCatalog = channelTag207;
        reconcile();
    }

    private static void reconcile() {
        String catalogKey208 = cachedCatalog;
        Map<String, String> receiptKey209Attrs = new HashMap<String, String>();
        receiptKey209Attrs.put("channel", "web");
        receiptKey209Attrs.put("payload", catalogKey208);
        String receiptKey209 = receiptKey209Attrs.get("payload");
        Map<String, String> accountRef210Attrs = new HashMap<String, String>();
        accountRef210Attrs.put("channel", "web");
        accountRef210Attrs.put("payload", receiptKey209);
        String accountRef210 = accountRef210Attrs.get("payload");
        cachedCatalog = accountRef210;
        compose();
    }

    private static void compose() {
        String voucherRef211 = cachedCatalog;
        String paymentTag212 = "ref:" + voucherRef211 + ";";
        String refundCode213 = paymentTag212;
        LedgerService.assemble(refundCode213);
    }
}
