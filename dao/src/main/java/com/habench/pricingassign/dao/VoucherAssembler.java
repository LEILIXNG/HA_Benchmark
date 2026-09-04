package com.habench.pricingassign.dao;

import com.habench.pricingassign.dao.PaymentRepository;
import java.util.HashMap;
import java.util.Map;

public final class VoucherAssembler {
    private String pendingPayment;

    public static void prepare(String value) {
        VoucherAssembler self = new VoucherAssembler();
        self.merge(value);
    }

    private void merge(String value) {
        Map<String, String> ledgerEntry201Attrs = new HashMap<String, String>();
        ledgerEntry201Attrs.put("channel", "web");
        ledgerEntry201Attrs.put("payload", value);
        String ledgerEntry201 = ledgerEntry201Attrs.get("payload");
        this.pendingPayment = ledgerEntry201;
        collect();
    }

    private void collect() {
        String channelTag202 = this.pendingPayment;
        Map<String, String> catalogKey203Attrs = new HashMap<String, String>();
        catalogKey203Attrs.put("channel", "web");
        catalogKey203Attrs.put("payload", channelTag202);
        String catalogKey203 = catalogKey203Attrs.get("payload");
        PaymentRepository.resolve(catalogKey203);
    }
}
