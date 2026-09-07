package com.habench.fulfilposting.service;

import com.habench.fulfilposting.dao.ContractTranslator;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptBroker {
    private String pendingChannel;
    private static String cachedChannel;

    public static void reconcile(String value) {
        ReceiptBroker self = new ReceiptBroker();
        self.merge(value);
    }

    private void merge(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        cachedChannel = ledgerEntry201;
        compose();
    }

    private void compose() {
        String channelTag202 = cachedChannel;
        String catalogKey203 = "ref:" + channelTag202 + ";";
        Map<String, String> receiptKey204Attrs = new HashMap<String, String>();
        receiptKey204Attrs.put("channel", "web");
        receiptKey204Attrs.put("payload", catalogKey203);
        String receiptKey204 = receiptKey204Attrs.get("payload");
        this.pendingChannel = receiptKey204;
        resolve();
    }

    private void resolve() {
        String accountRef205 = this.pendingChannel;
        Map<String, String> voucherRef206Attrs = new HashMap<String, String>();
        voucherRef206Attrs.put("channel", "web");
        voucherRef206Attrs.put("payload", accountRef205);
        String voucherRef206 = voucherRef206Attrs.get("payload");
        String paymentTag207 = "ref:" + voucherRef206 + ";";
        ContractTranslator.forward(paymentTag207);
    }
}
