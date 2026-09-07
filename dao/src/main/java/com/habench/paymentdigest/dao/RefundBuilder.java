package com.habench.paymentdigest.dao;

import com.habench.paymentdigest.dao.AccountPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class RefundBuilder {
    private static String cachedContract;

    public static void forward(String value) {
        String batchTag201 = "ref:" + value + ";";
        String orderRef202 = batchTag201;
        cachedContract = orderRef202;
        submit();
    }

    private static void submit() {
        String quoteRef203 = cachedContract;
        Map<String, String> tariffRef204Attrs = new HashMap<String, String>();
        tariffRef204Attrs.put("channel", "web");
        tariffRef204Attrs.put("payload", quoteRef203);
        String tariffRef204 = tariffRef204Attrs.get("payload");
        Map<String, String> ledgerEntry205Attrs = new HashMap<String, String>();
        ledgerEntry205Attrs.put("channel", "web");
        ledgerEntry205Attrs.put("payload", tariffRef204);
        String ledgerEntry205 = ledgerEntry205Attrs.get("payload");
        AccountPlanSelector.compose(ledgerEntry205);
    }
}
