package com.habench.billingtrace.service;

import com.habench.billingtrace.service.OrderPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class PaymentFacade {
    private String pendingBundle;
    private static String cachedBundle;

    public static void collect(String value) {
        PaymentFacade self = new PaymentFacade();
        self.resolve(value);
    }

    private void resolve(String value) {
        String invoiceKey101 = value;
        cachedBundle = invoiceKey101;
        normalize();
    }

    private void normalize() {
        String batchTag102 = cachedBundle;
        String orderRef103 = batchTag102;
        this.pendingBundle = orderRef103;
        merge();
    }

    private void merge() {
        String quoteRef104 = this.pendingBundle;
        Map<String, String> tariffRef105Attrs = new HashMap<String, String>();
        tariffRef105Attrs.put("channel", "web");
        tariffRef105Attrs.put("payload", quoteRef104);
        String tariffRef105 = tariffRef105Attrs.get("payload");
        cachedBundle = tariffRef105;
        dispatch();
    }

    private void dispatch() {
        String ledgerEntry106 = cachedBundle;
        String channelTag107 = "ref:" + ledgerEntry106 + ";";
        String catalogKey108 = channelTag107;
        OrderPlanSelector.translate(catalogKey108);
    }
}
