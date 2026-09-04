package com.habench.billingquote.web;

import com.habench.billingquote.service.QuoteFacade;
import java.util.HashMap;
import java.util.Map;

public final class LedgerRouter {
    private String pendingSession;
    private static String cachedSession;

    public static void normalize(String value) {
        LedgerRouter self = new LedgerRouter();
        self.forward(value);
    }

    private void forward(String value) {
        String catalogKey1 = "ref:" + value + ";";
        this.pendingSession = catalogKey1;
        resolve();
    }

    private void resolve() {
        String receiptKey2 = this.pendingSession;
        String accountRef3 = "ref:" + receiptKey2 + ";";
        Map<String, String> voucherRef4Attrs = new HashMap<String, String>();
        voucherRef4Attrs.put("channel", "web");
        voucherRef4Attrs.put("payload", accountRef3);
        String voucherRef4 = voucherRef4Attrs.get("payload");
        cachedSession = voucherRef4;
        assemble();
    }

    private void assemble() {
        String paymentTag5 = cachedSession;
        String refundCode6 = "ref:" + paymentTag5 + ";";
        String shipmentCode7 = "ref:" + refundCode6 + ";";
        cachedSession = shipmentCode7;
        dispatch();
    }

    private void dispatch() {
        String manifestKey8 = cachedSession;
        Map<String, String> invoiceKey9Attrs = new HashMap<String, String>();
        invoiceKey9Attrs.put("channel", "web");
        invoiceKey9Attrs.put("payload", manifestKey8);
        String invoiceKey9 = invoiceKey9Attrs.get("payload");
        Map<String, String> batchTag10Attrs = new HashMap<String, String>();
        batchTag10Attrs.put("channel", "web");
        batchTag10Attrs.put("payload", invoiceKey9);
        String batchTag10 = batchTag10Attrs.get("payload");
        cachedSession = batchTag10;
        compose();
    }

    private void compose() {
        String orderRef11 = cachedSession;
        String quoteRef12 = orderRef11;
        Map<String, String> tariffRef13Attrs = new HashMap<String, String>();
        tariffRef13Attrs.put("channel", "web");
        tariffRef13Attrs.put("payload", quoteRef12);
        String tariffRef13 = tariffRef13Attrs.get("payload");
        this.pendingSession = tariffRef13;
        prepare();
    }

    private void prepare() {
        String ledgerEntry14 = this.pendingSession;
        String channelTag15 = "ref:" + ledgerEntry14 + ";";
        cachedSession = channelTag15;
        submit();
    }

    private void submit() {
        String catalogKey16 = cachedSession;
        Map<String, String> receiptKey17Attrs = new HashMap<String, String>();
        receiptKey17Attrs.put("channel", "web");
        receiptKey17Attrs.put("payload", catalogKey16);
        String receiptKey17 = receiptKey17Attrs.get("payload");
        String accountRef18 = "ref:" + receiptKey17 + ";";
        QuoteFacade.forward(accountRef18);
    }
}
