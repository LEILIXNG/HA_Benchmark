package com.habench.pricingmanifest.web;

import com.habench.pricingmanifest.service.VoucherRegistry;
import java.util.HashMap;
import java.util.Map;

public final class AccountComposer {
    private static String cachedQuote;

    public static void compose(String value) {
        String catalogKey201 = value;
        String receiptKey202 = "ref:" + catalogKey201 + ";";
        cachedQuote = receiptKey202;
        forward();
    }

    private static void forward() {
        String accountRef203 = cachedQuote;
        Map<String, String> voucherRef204Attrs = new HashMap<String, String>();
        voucherRef204Attrs.put("channel", "web");
        voucherRef204Attrs.put("payload", accountRef203);
        String voucherRef204 = voucherRef204Attrs.get("payload");
        String paymentTag205 = voucherRef204;
        VoucherRegistry.assemble(paymentTag205);
    }
}
