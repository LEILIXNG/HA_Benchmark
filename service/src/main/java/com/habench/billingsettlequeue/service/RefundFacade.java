package com.habench.billingsettlequeue.service;

import com.habench.billingsettlequeue.dao.OrderNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class RefundFacade {
    private static String cachedTariff;

    public static void resolve(String value) {
        String shipmentCode101 = value;
        String manifestKey102 = shipmentCode101;
        cachedTariff = manifestKey102;
        prepare();
    }

    private static void prepare() {
        String invoiceKey103 = cachedTariff;
        Map<String, String> batchTag104Attrs = new HashMap<String, String>();
        batchTag104Attrs.put("channel", "web");
        batchTag104Attrs.put("payload", invoiceKey103);
        String batchTag104 = batchTag104Attrs.get("payload");
        cachedTariff = batchTag104;
        refine();
    }

    private static void refine() {
        String orderRef105 = cachedTariff;
        String quoteRef106 = orderRef105;
        String tariffRef107 = quoteRef106;
        OrderNormalizer.reconcile(tariffRef107);
    }
}
