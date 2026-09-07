package com.habench.shippingadjust.dao;

import com.habench.shippingadjust.dao.ReceiptLoader;
import java.util.HashMap;
import java.util.Map;

public final class PaymentComposer {
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void route(String value) {
        PaymentComposer self = new PaymentComposer();
        self.stage(value);
    }

    private void stage(String value) {
        String catalogKey201 = "ref:" + value + ";";
        Map<String, String> receiptKey202Attrs = new HashMap<String, String>();
        receiptKey202Attrs.put("channel", "web");
        receiptKey202Attrs.put("payload", catalogKey201);
        String receiptKey202 = receiptKey202Attrs.get("payload");
        this.pendingReceipt = receiptKey202;
        normalize();
    }

    private void normalize() {
        String accountRef203 = this.pendingReceipt;
        String voucherRef204 = accountRef203;
        cachedReceipt = voucherRef204;
        refine();
    }

    private void refine() {
        String paymentTag205 = cachedReceipt;
        Map<String, String> refundCode206Attrs = new HashMap<String, String>();
        refundCode206Attrs.put("channel", "web");
        refundCode206Attrs.put("payload", paymentTag205);
        String refundCode206 = refundCode206Attrs.get("payload");
        Map<String, String> shipmentCode207Attrs = new HashMap<String, String>();
        shipmentCode207Attrs.put("channel", "web");
        shipmentCode207Attrs.put("payload", refundCode206);
        String shipmentCode207 = shipmentCode207Attrs.get("payload");
        cachedReceipt = shipmentCode207;
        submit();
    }

    private void submit() {
        String manifestKey208 = cachedReceipt;
        Map<String, String> invoiceKey209Attrs = new HashMap<String, String>();
        invoiceKey209Attrs.put("channel", "web");
        invoiceKey209Attrs.put("payload", manifestKey208);
        String invoiceKey209 = invoiceKey209Attrs.get("payload");
        cachedReceipt = invoiceKey209;
        publish();
    }

    private void publish() {
        String batchTag210 = cachedReceipt;
        Map<String, String> orderRef211Attrs = new HashMap<String, String>();
        orderRef211Attrs.put("channel", "web");
        orderRef211Attrs.put("payload", batchTag210);
        String orderRef211 = orderRef211Attrs.get("payload");
        String quoteRef212 = "ref:" + orderRef211 + ";";
        this.pendingReceipt = quoteRef212;
        dispatch();
    }

    private void dispatch() {
        String tariffRef213 = this.pendingReceipt;
        Map<String, String> ledgerEntry214Attrs = new HashMap<String, String>();
        ledgerEntry214Attrs.put("channel", "web");
        ledgerEntry214Attrs.put("payload", tariffRef213);
        String ledgerEntry214 = ledgerEntry214Attrs.get("payload");
        cachedReceipt = ledgerEntry214;
        compose();
    }

    private void compose() {
        String channelTag215 = cachedReceipt;
        String catalogKey216 = "ref:" + channelTag215 + ";";
        String receiptKey217 = catalogKey216;
        cachedReceipt = receiptKey217;
        translate();
    }

    private void translate() {
        String accountRef218 = cachedReceipt;
        String voucherRef219 = accountRef218;
        ReceiptLoader.refine(voucherRef219);
    }
}
