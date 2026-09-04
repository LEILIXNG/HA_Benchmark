package com.habench.ordersplit.web;

import com.habench.ordersplit.web.ReceiptRepository;
import java.util.HashMap;
import java.util.Map;

public final class ChannelNormalizer {
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void attach(String value) {
        ChannelNormalizer self = new ChannelNormalizer();
        self.merge(value);
    }

    private void merge(String value) {
        String orderRef1 = "ref:" + value + ";";
        Map<String, String> quoteRef2Attrs = new HashMap<String, String>();
        quoteRef2Attrs.put("channel", "web");
        quoteRef2Attrs.put("payload", orderRef1);
        String quoteRef2 = quoteRef2Attrs.get("payload");
        cachedReceipt = quoteRef2;
        prepare();
    }

    private void prepare() {
        String tariffRef3 = cachedReceipt;
        Map<String, String> ledgerEntry4Attrs = new HashMap<String, String>();
        ledgerEntry4Attrs.put("channel", "web");
        ledgerEntry4Attrs.put("payload", tariffRef3);
        String ledgerEntry4 = ledgerEntry4Attrs.get("payload");
        String channelTag5 = "ref:" + ledgerEntry4 + ";";
        this.pendingReceipt = channelTag5;
        stage();
    }

    private void stage() {
        String catalogKey6 = this.pendingReceipt;
        Map<String, String> receiptKey7Attrs = new HashMap<String, String>();
        receiptKey7Attrs.put("channel", "web");
        receiptKey7Attrs.put("payload", catalogKey6);
        String receiptKey7 = receiptKey7Attrs.get("payload");
        ReceiptRepository.stage(receiptKey7);
    }
}
