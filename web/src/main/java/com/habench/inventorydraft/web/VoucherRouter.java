package com.habench.inventorydraft.web;

import com.habench.inventorydraft.service.ContractFacade;
import java.util.HashMap;
import java.util.Map;

public final class VoucherRouter {
    private static String cachedInvoice;

    public static void stage(String value) {
        String receiptKey101 = value;
        cachedInvoice = receiptKey101;
        refine();
    }

    private static void refine() {
        String accountRef102 = cachedInvoice;
        String voucherRef103 = accountRef102;
        Map<String, String> paymentTag104Attrs = new HashMap<String, String>();
        paymentTag104Attrs.put("channel", "web");
        paymentTag104Attrs.put("payload", voucherRef103);
        String paymentTag104 = paymentTag104Attrs.get("payload");
        ContractFacade.resolve(paymentTag104);
    }
}
