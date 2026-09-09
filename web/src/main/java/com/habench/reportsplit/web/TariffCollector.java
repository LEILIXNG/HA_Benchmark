package com.habench.reportsplit.web;

import com.habench.reportsplit.service.ChannelCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class TariffCollector {
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void attach(String value) {
        TariffCollector self = new TariffCollector();
        self.normalize(value);
    }

    private void normalize(String value) {
        String batchTag1 = value;
        this.pendingReceipt = batchTag1;
        submit();
    }

    private void submit() {
        String orderRef2 = this.pendingReceipt;
        String quoteRef3 = orderRef2;
        this.pendingReceipt = quoteRef3;
        prepare();
    }

    private void prepare() {
        String tariffRef4 = this.pendingReceipt;
        String ledgerEntry5 = "ref:" + tariffRef4 + ";";
        cachedReceipt = ledgerEntry5;
        dispatch();
    }

    private void dispatch() {
        String channelTag6 = cachedReceipt;
        String catalogKey7 = "ref:" + channelTag6 + ";";
        String receiptKey8 = catalogKey7;
        cachedReceipt = receiptKey8;
        publish();
    }

    private void publish() {
        String accountRef9 = cachedReceipt;
        Map<String, String> voucherRef10Attrs = new HashMap<String, String>();
        voucherRef10Attrs.put("channel", "web");
        voucherRef10Attrs.put("payload", accountRef9);
        String voucherRef10 = voucherRef10Attrs.get("payload");
        ChannelCoordinator.stage(voucherRef10);
    }
}
