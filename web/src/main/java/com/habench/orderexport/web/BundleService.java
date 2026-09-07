package com.habench.orderexport.web;

import com.habench.orderexport.web.CatalogRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class BundleService {
    private static String cachedChannel;

    public static void route(String value) {
        String receiptKey1 = "ref:" + value + ";";
        Map<String, String> accountRef2Attrs = new HashMap<String, String>();
        accountRef2Attrs.put("channel", "web");
        accountRef2Attrs.put("payload", receiptKey1);
        String accountRef2 = accountRef2Attrs.get("payload");
        cachedChannel = accountRef2;
        collect();
    }

    private static void collect() {
        String voucherRef3 = cachedChannel;
        Map<String, String> paymentTag4Attrs = new HashMap<String, String>();
        paymentTag4Attrs.put("channel", "web");
        paymentTag4Attrs.put("payload", voucherRef3);
        String paymentTag4 = paymentTag4Attrs.get("payload");
        String refundCode5 = "ref:" + paymentTag4 + ";";
        CatalogRuleSelector.compose(refundCode5);
    }
}
