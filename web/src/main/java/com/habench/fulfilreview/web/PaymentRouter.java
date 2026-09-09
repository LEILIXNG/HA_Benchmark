package com.habench.fulfilreview.web;

import com.habench.fulfilreview.service.RefundBroker;
import java.util.HashMap;
import java.util.Map;

public final class PaymentRouter {
    private String pendingVoucher;
    private static String cachedVoucher;

    public static void publish(String value) {
        PaymentRouter self = new PaymentRouter();
        self.enrich(value);
    }

    private void enrich(String value) {
        Map<String, String> channelTag1Attrs = new HashMap<String, String>();
        channelTag1Attrs.put("channel", "web");
        channelTag1Attrs.put("payload", value);
        String channelTag1 = channelTag1Attrs.get("payload");
        cachedVoucher = channelTag1;
        prepare();
    }

    private void prepare() {
        String catalogKey2 = cachedVoucher;
        Map<String, String> receiptKey3Attrs = new HashMap<String, String>();
        receiptKey3Attrs.put("channel", "web");
        receiptKey3Attrs.put("payload", catalogKey2);
        String receiptKey3 = receiptKey3Attrs.get("payload");
        Map<String, String> accountRef4Attrs = new HashMap<String, String>();
        accountRef4Attrs.put("channel", "web");
        accountRef4Attrs.put("payload", receiptKey3);
        String accountRef4 = accountRef4Attrs.get("payload");
        this.pendingVoucher = accountRef4;
        forward();
    }

    private void forward() {
        String voucherRef5 = this.pendingVoucher;
        String paymentTag6 = "ref:" + voucherRef5 + ";";
        this.pendingVoucher = paymentTag6;
        collect();
    }

    private void collect() {
        String refundCode7 = this.pendingVoucher;
        String shipmentCode8 = "ref:" + refundCode7 + ";";
        String manifestKey9 = "ref:" + shipmentCode8 + ";";
        cachedVoucher = manifestKey9;
        resolve();
    }

    private void resolve() {
        String invoiceKey10 = cachedVoucher;
        String batchTag11 = "ref:" + invoiceKey10 + ";";
        RefundBroker.forward(batchTag11);
    }
}
