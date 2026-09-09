package com.habench.ordermerge.web;

import com.habench.ordermerge.web.TariffPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class BatchAdapter {
    private String pendingShipment;

    public static void expand(String value) {
        BatchAdapter self = new BatchAdapter();
        self.merge(value);
    }

    private void merge(String value) {
        Map<String, String> accountRef1Attrs = new HashMap<String, String>();
        accountRef1Attrs.put("channel", "web");
        accountRef1Attrs.put("payload", value);
        String accountRef1 = accountRef1Attrs.get("payload");
        this.pendingShipment = accountRef1;
        route();
    }

    private void route() {
        String voucherRef2 = this.pendingShipment;
        String paymentTag3 = voucherRef2;
        String refundCode4 = paymentTag3;
        TariffPlanSelector.expand(refundCode4);
    }
}
