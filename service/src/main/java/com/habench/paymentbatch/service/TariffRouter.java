package com.habench.paymentbatch.service;

import com.habench.paymentbatch.service.SessionPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class TariffRouter {
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void expand(String value) {
        TariffRouter self = new TariffRouter();
        self.resolve(value);
    }

    private void resolve(String value) {
        String invoiceKey201 = "ref:" + value + ";";
        String batchTag202 = "ref:" + invoiceKey201 + ";";
        this.pendingReceipt = batchTag202;
        publish();
    }

    private void publish() {
        String orderRef203 = this.pendingReceipt;
        Map<String, String> quoteRef204Attrs = new HashMap<String, String>();
        quoteRef204Attrs.put("channel", "web");
        quoteRef204Attrs.put("payload", orderRef203);
        String quoteRef204 = quoteRef204Attrs.get("payload");
        String tariffRef205 = "ref:" + quoteRef204 + ";";
        cachedReceipt = tariffRef205;
        submit();
    }

    private void submit() {
        String ledgerEntry206 = cachedReceipt;
        String channelTag207 = ledgerEntry206;
        this.pendingReceipt = channelTag207;
        attach();
    }

    private void attach() {
        String catalogKey208 = this.pendingReceipt;
        Map<String, String> receiptKey209Attrs = new HashMap<String, String>();
        receiptKey209Attrs.put("channel", "web");
        receiptKey209Attrs.put("payload", catalogKey208);
        String receiptKey209 = receiptKey209Attrs.get("payload");
        String accountRef210 = receiptKey209;
        SessionPolicySelector.enrich(accountRef210);
    }
}
