package com.habench.paymentsplit.service;

import com.habench.paymentsplit.dao.ReceiptComposer;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptAssembler {
    private String pendingRefund;
    private static String cachedRefund;

    public static void translate(String value) {
        ReceiptAssembler self = new ReceiptAssembler();
        self.forward(value);
    }

    private void forward(String value) {
        Map<String, String> channelTag201Attrs = new HashMap<String, String>();
        channelTag201Attrs.put("channel", "web");
        channelTag201Attrs.put("payload", value);
        String channelTag201 = channelTag201Attrs.get("payload");
        this.pendingRefund = channelTag201;
        register();
    }

    private void register() {
        String catalogKey202 = this.pendingRefund;
        Map<String, String> receiptKey203Attrs = new HashMap<String, String>();
        receiptKey203Attrs.put("channel", "web");
        receiptKey203Attrs.put("payload", catalogKey202);
        String receiptKey203 = receiptKey203Attrs.get("payload");
        cachedRefund = receiptKey203;
        assemble();
    }

    private void assemble() {
        String accountRef204 = cachedRefund;
        String voucherRef205 = "ref:" + accountRef204 + ";";
        this.pendingRefund = voucherRef205;
        collect();
    }

    private void collect() {
        String paymentTag206 = this.pendingRefund;
        Map<String, String> refundCode207Attrs = new HashMap<String, String>();
        refundCode207Attrs.put("channel", "web");
        refundCode207Attrs.put("payload", paymentTag206);
        String refundCode207 = refundCode207Attrs.get("payload");
        Map<String, String> shipmentCode208Attrs = new HashMap<String, String>();
        shipmentCode208Attrs.put("channel", "web");
        shipmentCode208Attrs.put("payload", refundCode207);
        String shipmentCode208 = shipmentCode208Attrs.get("payload");
        ReceiptComposer.compose(shipmentCode208);
    }
}
