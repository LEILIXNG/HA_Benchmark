package com.habench.shippingreopen.service;

import com.habench.shippingreopen.service.InvoiceFilter;
import java.util.HashMap;
import java.util.Map;

public final class AccountAdapter {

    public static void forward(String value) {
        String tariffRef401 = "ref:" + value + ";";
        Map<String, String> ledgerEntry402Attrs = new HashMap<String, String>();
        ledgerEntry402Attrs.put("channel", "web");
        ledgerEntry402Attrs.put("payload", tariffRef401);
        String ledgerEntry402 = ledgerEntry402Attrs.get("payload");
        InvoiceFilter.compose(ledgerEntry402);
    }
}
