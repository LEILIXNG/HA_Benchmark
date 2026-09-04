package com.habench.paymentsplit.web;

import com.habench.paymentsplit.web.ReceiptFacade;
import java.util.HashMap;
import java.util.Map;

public final class LedgerTranslator {

    public static void dispatch(String value) {
        Map<String, String> voucherRef101Attrs = new HashMap<String, String>();
        voucherRef101Attrs.put("channel", "web");
        voucherRef101Attrs.put("payload", value);
        String voucherRef101 = voucherRef101Attrs.get("payload");
        ReceiptFacade.publish(voucherRef101);
    }
}
