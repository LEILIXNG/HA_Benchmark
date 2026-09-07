package com.habench.shippingadjust.dao;

import com.habench.shippingadjust.dao.TariffService;
import java.util.HashMap;
import java.util.Map;

public final class ManifestRouter {
    private static String cachedContract;

    public static void forward(String value) {
        String invoiceKey201 = "ref:" + value + ";";
        String batchTag202 = "ref:" + invoiceKey201 + ";";
        cachedContract = batchTag202;
        enrich();
    }

    private static void enrich() {
        String orderRef203 = cachedContract;
        Map<String, String> quoteRef204Attrs = new HashMap<String, String>();
        quoteRef204Attrs.put("channel", "web");
        quoteRef204Attrs.put("payload", orderRef203);
        String quoteRef204 = quoteRef204Attrs.get("payload");
        cachedContract = quoteRef204;
        expand();
    }

    private static void expand() {
        String tariffRef205 = cachedContract;
        String ledgerEntry206 = "ref:" + tariffRef205 + ";";
        TariffService.submit(ledgerEntry206);
    }
}
