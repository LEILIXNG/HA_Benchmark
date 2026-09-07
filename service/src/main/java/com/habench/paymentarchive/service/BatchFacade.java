package com.habench.paymentarchive.service;

import com.habench.paymentarchive.service.ContractStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class BatchFacade {
    private String pendingTariff;
    private static String cachedTariff;

    public static void forward(String value) {
        BatchFacade self = new BatchFacade();
        self.expand(value);
    }

    private void expand(String value) {
        String paymentTag101 = "ref:" + value + ";";
        this.pendingTariff = paymentTag101;
        submit();
    }

    private void submit() {
        String refundCode102 = this.pendingTariff;
        String shipmentCode103 = "ref:" + refundCode102 + ";";
        cachedTariff = shipmentCode103;
        route();
    }

    private void route() {
        String manifestKey104 = cachedTariff;
        Map<String, String> invoiceKey105Attrs = new HashMap<String, String>();
        invoiceKey105Attrs.put("channel", "web");
        invoiceKey105Attrs.put("payload", manifestKey104);
        String invoiceKey105 = invoiceKey105Attrs.get("payload");
        ContractStrategySelector.merge(invoiceKey105);
    }
}
