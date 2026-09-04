package com.habench.orderassign.dao;

import com.habench.orderassign.dao.ReceiptRepository;
import java.util.HashMap;
import java.util.Map;

public final class ContractTranslator {
    private static String cachedReceipt;

    public static void dispatch(String value) {
        String channelTag501 = value;
        cachedReceipt = channelTag501;
        expand();
    }

    private static void expand() {
        String catalogKey502 = cachedReceipt;
        String receiptKey503 = "ref:" + catalogKey502 + ";";
        Map<String, String> accountRef504Attrs = new HashMap<String, String>();
        accountRef504Attrs.put("channel", "web");
        accountRef504Attrs.put("payload", receiptKey503);
        String accountRef504 = accountRef504Attrs.get("payload");
        cachedReceipt = accountRef504;
        translate();
    }

    private static void translate() {
        String voucherRef505 = cachedReceipt;
        Map<String, String> paymentTag506Attrs = new HashMap<String, String>();
        paymentTag506Attrs.put("channel", "web");
        paymentTag506Attrs.put("payload", voucherRef505);
        String paymentTag506 = paymentTag506Attrs.get("payload");
        cachedReceipt = paymentTag506;
        prepare();
    }

    private static void prepare() {
        String refundCode507 = cachedReceipt;
        String shipmentCode508 = "ref:" + refundCode507 + ";";
        ReceiptRepository.refine(shipmentCode508);
    }
}
