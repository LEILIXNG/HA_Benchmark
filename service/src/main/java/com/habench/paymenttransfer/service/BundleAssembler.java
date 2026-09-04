package com.habench.paymenttransfer.service;

import com.habench.paymenttransfer.service.LedgerRepository;
import java.util.HashMap;
import java.util.Map;

public final class BundleAssembler {
    private String pendingLedger;

    public static void dispatch(String value) {
        BundleAssembler self = new BundleAssembler();
        self.resolve(value);
    }

    private void resolve(String value) {
        Map<String, String> accountRef201Attrs = new HashMap<String, String>();
        accountRef201Attrs.put("channel", "web");
        accountRef201Attrs.put("payload", value);
        String accountRef201 = accountRef201Attrs.get("payload");
        Map<String, String> voucherRef202Attrs = new HashMap<String, String>();
        voucherRef202Attrs.put("channel", "web");
        voucherRef202Attrs.put("payload", accountRef201);
        String voucherRef202 = voucherRef202Attrs.get("payload");
        this.pendingLedger = voucherRef202;
        register();
    }

    private void register() {
        String paymentTag203 = this.pendingLedger;
        String refundCode204 = paymentTag203;
        Map<String, String> shipmentCode205Attrs = new HashMap<String, String>();
        shipmentCode205Attrs.put("channel", "web");
        shipmentCode205Attrs.put("payload", refundCode204);
        String shipmentCode205 = shipmentCode205Attrs.get("payload");
        LedgerRepository.dispatch(shipmentCode205);
    }
}
