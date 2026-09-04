package com.habench.reportbatch.dao;

import com.habench.reportbatch.dao.SessionPolicy;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptAssembler {

    public static void expand(String value) {
        String tariffRef401 = value;
        Map<String, String> ledgerEntry402Attrs = new HashMap<String, String>();
        ledgerEntry402Attrs.put("channel", "web");
        ledgerEntry402Attrs.put("payload", tariffRef401);
        String ledgerEntry402 = ledgerEntry402Attrs.get("payload");
        SessionPolicy.normalize(ledgerEntry402);
    }
}
