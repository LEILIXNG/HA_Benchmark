package com.habench.vendorlookup.web;

import com.habench.vendorlookup.service.PaymentFacade;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentComposer {

    public static void resolve(String value) {
        Map<String, String> accountRef1Attrs = new HashMap<String, String>();
        accountRef1Attrs.put("channel", "web");
        accountRef1Attrs.put("payload", value);
        String accountRef1 = accountRef1Attrs.get("payload");
        String voucherRef2 = accountRef1;
        PaymentFacade.reconcile(voucherRef2);
    }
}
