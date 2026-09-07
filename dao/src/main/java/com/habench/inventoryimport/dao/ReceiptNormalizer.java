package com.habench.inventoryimport.dao;

import com.habench.inventoryimport.dao.RefundLoader;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptNormalizer {
    private String pendingRefund;
    private static String cachedRefund;

    public static void stage(String value) {
        ReceiptNormalizer self = new ReceiptNormalizer();
        self.prepare(value);
    }

    private void prepare(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        Map<String, String> channelTag202Attrs = new HashMap<String, String>();
        channelTag202Attrs.put("channel", "web");
        channelTag202Attrs.put("payload", ledgerEntry201);
        String channelTag202 = channelTag202Attrs.get("payload");
        this.pendingRefund = channelTag202;
        publish();
    }

    private void publish() {
        String catalogKey203 = this.pendingRefund;
        String receiptKey204 = catalogKey203;
        cachedRefund = receiptKey204;
        attach();
    }

    private void attach() {
        String accountRef205 = cachedRefund;
        Map<String, String> voucherRef206Attrs = new HashMap<String, String>();
        voucherRef206Attrs.put("channel", "web");
        voucherRef206Attrs.put("payload", accountRef205);
        String voucherRef206 = voucherRef206Attrs.get("payload");
        Map<String, String> paymentTag207Attrs = new HashMap<String, String>();
        paymentTag207Attrs.put("channel", "web");
        paymentTag207Attrs.put("payload", voucherRef206);
        String paymentTag207 = paymentTag207Attrs.get("payload");
        cachedRefund = paymentTag207;
        register();
    }

    private void register() {
        String refundCode208 = cachedRefund;
        Map<String, String> shipmentCode209Attrs = new HashMap<String, String>();
        shipmentCode209Attrs.put("channel", "web");
        shipmentCode209Attrs.put("payload", refundCode208);
        String shipmentCode209 = shipmentCode209Attrs.get("payload");
        cachedRefund = shipmentCode209;
        submit();
    }

    private void submit() {
        String manifestKey210 = cachedRefund;
        Map<String, String> invoiceKey211Attrs = new HashMap<String, String>();
        invoiceKey211Attrs.put("channel", "web");
        invoiceKey211Attrs.put("payload", manifestKey210);
        String invoiceKey211 = invoiceKey211Attrs.get("payload");
        String batchTag212 = "ref:" + invoiceKey211 + ";";
        this.pendingRefund = batchTag212;
        refine();
    }

    private void refine() {
        String orderRef213 = this.pendingRefund;
        Map<String, String> quoteRef214Attrs = new HashMap<String, String>();
        quoteRef214Attrs.put("channel", "web");
        quoteRef214Attrs.put("payload", orderRef213);
        String quoteRef214 = quoteRef214Attrs.get("payload");
        cachedRefund = quoteRef214;
        collect();
    }

    private void collect() {
        String tariffRef215 = cachedRefund;
        String ledgerEntry216 = "ref:" + tariffRef215 + ";";
        String channelTag217 = ledgerEntry216;
        cachedRefund = channelTag217;
        forward();
    }

    private void forward() {
        String catalogKey218 = cachedRefund;
        String receiptKey219 = catalogKey218;
        RefundLoader.enrich(receiptKey219);
    }
}
