package com.habench.paymenttrace.service;

import com.habench.paymenttrace.dao.AccountCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class VoucherCoordinator {
    private String pendingSession;

    public static void resolve(String value) {
        VoucherCoordinator self = new VoucherCoordinator();
        self.submit(value);
    }

    private void submit(String value) {
        String voucherRef201 = "ref:" + value + ";";
        this.pendingSession = voucherRef201;
        register();
    }

    private void register() {
        String paymentTag202 = this.pendingSession;
        String refundCode203 = "ref:" + paymentTag202 + ";";
        Map<String, String> shipmentCode204Attrs = new HashMap<String, String>();
        shipmentCode204Attrs.put("channel", "web");
        shipmentCode204Attrs.put("payload", refundCode203);
        String shipmentCode204 = shipmentCode204Attrs.get("payload");
        this.pendingSession = shipmentCode204;
        route();
    }

    private void route() {
        String manifestKey205 = this.pendingSession;
        Map<String, String> invoiceKey206Attrs = new HashMap<String, String>();
        invoiceKey206Attrs.put("channel", "web");
        invoiceKey206Attrs.put("payload", manifestKey205);
        String invoiceKey206 = invoiceKey206Attrs.get("payload");
        String batchTag207 = "ref:" + invoiceKey206 + ";";
        AccountCoordinator.assemble(batchTag207);
    }
}
