package com.habench.pricingtrace.web;

import com.habench.pricingtrace.service.VoucherNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class OrderService {
    private String pendingTariff;

    public static void expand(String value) {
        OrderService self = new OrderService();
        self.attach(value);
    }

    private void attach(String value) {
        Map<String, String> batchTag101Attrs = new HashMap<String, String>();
        batchTag101Attrs.put("channel", "web");
        batchTag101Attrs.put("payload", value);
        String batchTag101 = batchTag101Attrs.get("payload");
        String orderRef102 = "ref:" + batchTag101 + ";";
        this.pendingTariff = orderRef102;
        merge();
    }

    private void merge() {
        String quoteRef103 = this.pendingTariff;
        String tariffRef104 = "ref:" + quoteRef103 + ";";
        this.pendingTariff = tariffRef104;
        assemble();
    }

    private void assemble() {
        String ledgerEntry105 = this.pendingTariff;
        String channelTag106 = ledgerEntry105;
        VoucherNormalizer.forward(channelTag106);
    }
}
