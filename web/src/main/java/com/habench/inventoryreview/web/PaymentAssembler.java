package com.habench.inventoryreview.web;

import com.habench.inventoryreview.service.LedgerComposer;
import java.util.HashMap;
import java.util.Map;

public final class PaymentAssembler {

    public static void publish(String value) {
        Map<String, String> accountRef1Attrs = new HashMap<String, String>();
        accountRef1Attrs.put("channel", "web");
        accountRef1Attrs.put("payload", value);
        String accountRef1 = accountRef1Attrs.get("payload");
        Map<String, String> voucherRef2Attrs = new HashMap<String, String>();
        voucherRef2Attrs.put("channel", "web");
        voucherRef2Attrs.put("payload", accountRef1);
        String voucherRef2 = voucherRef2Attrs.get("payload");
        LedgerComposer.dispatch(voucherRef2);
    }
}
