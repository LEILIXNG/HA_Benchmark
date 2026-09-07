package com.habench.billingtransfer.service;

import com.habench.billingtransfer.dao.CatalogCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class BatchCollector {
    private String pendingRefund;
    private static String cachedRefund;

    public static void translate(String value) {
        BatchCollector self = new BatchCollector();
        self.forward(value);
    }

    private void forward(String value) {
        String channelTag101 = value;
        Map<String, String> catalogKey102Attrs = new HashMap<String, String>();
        catalogKey102Attrs.put("channel", "web");
        catalogKey102Attrs.put("payload", channelTag101);
        String catalogKey102 = catalogKey102Attrs.get("payload");
        this.pendingRefund = catalogKey102;
        compose();
    }

    private void compose() {
        String receiptKey103 = this.pendingRefund;
        Map<String, String> accountRef104Attrs = new HashMap<String, String>();
        accountRef104Attrs.put("channel", "web");
        accountRef104Attrs.put("payload", receiptKey103);
        String accountRef104 = accountRef104Attrs.get("payload");
        Map<String, String> voucherRef105Attrs = new HashMap<String, String>();
        voucherRef105Attrs.put("channel", "web");
        voucherRef105Attrs.put("payload", accountRef104);
        String voucherRef105 = voucherRef105Attrs.get("payload");
        cachedRefund = voucherRef105;
        reconcile();
    }

    private void reconcile() {
        String paymentTag106 = cachedRefund;
        Map<String, String> refundCode107Attrs = new HashMap<String, String>();
        refundCode107Attrs.put("channel", "web");
        refundCode107Attrs.put("payload", paymentTag106);
        String refundCode107 = refundCode107Attrs.get("payload");
        CatalogCoordinator.prepare(refundCode107);
    }
}
