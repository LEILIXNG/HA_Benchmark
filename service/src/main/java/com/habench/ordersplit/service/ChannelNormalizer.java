package com.habench.ordersplit.service;

import com.habench.ordersplit.service.ReceiptRepository;
import java.util.HashMap;
import java.util.Map;

public final class ChannelNormalizer {
    private static String cachedReceipt;

    public static void merge(String value) {
        String channelTag201 = value;
        cachedReceipt = channelTag201;
        prepare();
    }

    private static void prepare() {
        String catalogKey202 = cachedReceipt;
        Map<String, String> receiptKey203Attrs = new HashMap<String, String>();
        receiptKey203Attrs.put("channel", "web");
        receiptKey203Attrs.put("payload", catalogKey202);
        String receiptKey203 = receiptKey203Attrs.get("payload");
        String accountRef204 = "ref:" + receiptKey203 + ";";
        cachedReceipt = accountRef204;
        stage();
    }

    private static void stage() {
        String voucherRef205 = cachedReceipt;
        String paymentTag206 = voucherRef205;
        cachedReceipt = paymentTag206;
        attach();
    }

    private static void attach() {
        String refundCode207 = cachedReceipt;
        Map<String, String> shipmentCode208Attrs = new HashMap<String, String>();
        shipmentCode208Attrs.put("channel", "web");
        shipmentCode208Attrs.put("payload", refundCode207);
        String shipmentCode208 = shipmentCode208Attrs.get("payload");
        String manifestKey209 = "ref:" + shipmentCode208 + ";";
        cachedReceipt = manifestKey209;
        enrich();
    }

    private static void enrich() {
        String invoiceKey210 = cachedReceipt;
        Map<String, String> batchTag211Attrs = new HashMap<String, String>();
        batchTag211Attrs.put("channel", "web");
        batchTag211Attrs.put("payload", invoiceKey210);
        String batchTag211 = batchTag211Attrs.get("payload");
        ReceiptRepository.stage(batchTag211);
    }
}
