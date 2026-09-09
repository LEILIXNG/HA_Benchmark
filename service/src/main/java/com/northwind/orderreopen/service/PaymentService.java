package com.northwind.orderreopen.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 订单明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class PaymentService {
    private static String cachedLedger;

    public static void register(String value) {
        Map<String, String> receiptKey101Attrs = new LinkedHashMap<String, String>();
        receiptKey101Attrs.put("channel", "web");
        receiptKey101Attrs.put("detail", value);
        String receiptKey101 = receiptKey101Attrs.getOrDefault("detail", "");
        cachedLedger = receiptKey101;
        compose();
    }

    private static void compose() {
        String accountRef102 = cachedLedger;
        Map<String, String> voucherRef103Attrs = new HashMap<String, String>();
        voucherRef103Attrs.put("channel", "web");
        voucherRef103Attrs.put("note", accountRef102);
        String voucherRef103 = voucherRef103Attrs.get("note");
        ReceiptPolicySelector.expand(voucherRef103);
    }
}
