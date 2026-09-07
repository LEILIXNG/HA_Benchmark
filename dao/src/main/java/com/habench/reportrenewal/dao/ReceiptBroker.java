package com.habench.reportrenewal.dao;

import com.habench.reportrenewal.dao.VoucherFetcher;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptBroker {
    private static String cachedVoucher;

    public static void route(String value) {
        String catalogKey201 = value;
        cachedVoucher = catalogKey201;
        refine();
    }

    private static void refine() {
        String receiptKey202 = cachedVoucher;
        String accountRef203 = receiptKey202;
        cachedVoucher = accountRef203;
        attach();
    }

    private static void attach() {
        String voucherRef204 = cachedVoucher;
        Map<String, String> paymentTag205Attrs = new HashMap<String, String>();
        paymentTag205Attrs.put("channel", "web");
        paymentTag205Attrs.put("payload", voucherRef204);
        String paymentTag205 = paymentTag205Attrs.get("payload");
        VoucherFetcher.publish(paymentTag205);
    }
}
