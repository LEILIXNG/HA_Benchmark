package com.habench.catalogadjust.service;

import com.habench.catalogadjust.service.RefundFetcher;
import java.util.HashMap;
import java.util.Map;

public final class VoucherCollector {

    public static void expand(String value) {
        Map<String, String> tariffRef201Attrs = new HashMap<String, String>();
        tariffRef201Attrs.put("channel", "web");
        tariffRef201Attrs.put("payload", value);
        String tariffRef201 = tariffRef201Attrs.get("payload");
        String ledgerEntry202 = "ref:" + tariffRef201 + ";";
        RefundFetcher.expand(ledgerEntry202);
    }
}
