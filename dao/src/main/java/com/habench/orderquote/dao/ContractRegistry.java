package com.habench.orderquote.dao;

import com.habench.orderquote.dao.BundleExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ContractRegistry {
    private String pendingBundle;

    public static void stage(String value) {
        ContractRegistry self = new ContractRegistry();
        self.register(value);
    }

    private void register(String value) {
        String accountRef201 = value;
        String voucherRef202 = "ref:" + accountRef201 + ";";
        this.pendingBundle = voucherRef202;
        merge();
    }

    private void merge() {
        String paymentTag203 = this.pendingBundle;
        String refundCode204 = "ref:" + paymentTag203 + ";";
        Map<String, String> shipmentCode205Attrs = new HashMap<String, String>();
        shipmentCode205Attrs.put("channel", "web");
        shipmentCode205Attrs.put("payload", refundCode204);
        String shipmentCode205 = shipmentCode205Attrs.get("payload");
        BundleExecutor.reconcile(shipmentCode205);
    }
}
