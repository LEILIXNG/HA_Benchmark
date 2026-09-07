package com.habench.customersubmit.service;

import com.habench.customersubmit.dao.OrderResolver;
import java.util.HashMap;
import java.util.Map;

public final class ChannelRegistry {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void refine(String value) {
        ChannelRegistry self = new ChannelRegistry();
        self.assemble(value);
    }

    private void assemble(String value) {
        String receiptKey101 = value;
        Map<String, String> accountRef102Attrs = new HashMap<String, String>();
        accountRef102Attrs.put("channel", "web");
        accountRef102Attrs.put("payload", receiptKey101);
        String accountRef102 = accountRef102Attrs.get("payload");
        cachedCatalog = accountRef102;
        submit();
    }

    private void submit() {
        String voucherRef103 = cachedCatalog;
        String paymentTag104 = "ref:" + voucherRef103 + ";";
        this.pendingCatalog = paymentTag104;
        enrich();
    }

    private void enrich() {
        String refundCode105 = this.pendingCatalog;
        String shipmentCode106 = refundCode105;
        cachedCatalog = shipmentCode106;
        normalize();
    }

    private void normalize() {
        String manifestKey107 = cachedCatalog;
        String invoiceKey108 = "ref:" + manifestKey107 + ";";
        String batchTag109 = "ref:" + invoiceKey108 + ";";
        OrderResolver.stage(batchTag109);
    }
}
