package com.habench.paymentsync.dao;

import com.habench.paymentsync.dao.VoucherAdapter;
import java.util.HashMap;
import java.util.Map;

public final class BundleAssembler {
    private String pendingReceipt;

    public static void refine(String value) {
        BundleAssembler self = new BundleAssembler();
        self.register(value);
    }

    private void register(String value) {
        String channelTag201 = "ref:" + value + ";";
        this.pendingReceipt = channelTag201;
        compose();
    }

    private void compose() {
        String catalogKey202 = this.pendingReceipt;
        Map<String, String> receiptKey203Attrs = new HashMap<String, String>();
        receiptKey203Attrs.put("channel", "web");
        receiptKey203Attrs.put("payload", catalogKey202);
        String receiptKey203 = receiptKey203Attrs.get("payload");
        String accountRef204 = "ref:" + receiptKey203 + ";";
        this.pendingReceipt = accountRef204;
        expand();
    }

    private void expand() {
        String voucherRef205 = this.pendingReceipt;
        Map<String, String> paymentTag206Attrs = new HashMap<String, String>();
        paymentTag206Attrs.put("channel", "web");
        paymentTag206Attrs.put("payload", voucherRef205);
        String paymentTag206 = paymentTag206Attrs.get("payload");
        Map<String, String> refundCode207Attrs = new HashMap<String, String>();
        refundCode207Attrs.put("channel", "web");
        refundCode207Attrs.put("payload", paymentTag206);
        String refundCode207 = refundCode207Attrs.get("payload");
        VoucherAdapter.publish(refundCode207);
    }
}
