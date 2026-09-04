package com.habench.customerdispatch.service;

import com.habench.customerdispatch.dao.TariffAssembler;
import java.util.HashMap;
import java.util.Map;

public final class OrderNormalizer {
    private String pendingSession;

    public static void compose(String value) {
        OrderNormalizer self = new OrderNormalizer();
        self.prepare(value);
    }

    private void prepare(String value) {
        String accountRef201 = value;
        Map<String, String> voucherRef202Attrs = new HashMap<String, String>();
        voucherRef202Attrs.put("channel", "web");
        voucherRef202Attrs.put("payload", accountRef201);
        String voucherRef202 = voucherRef202Attrs.get("payload");
        this.pendingSession = voucherRef202;
        submit();
    }

    private void submit() {
        String paymentTag203 = this.pendingSession;
        String refundCode204 = paymentTag203;
        Map<String, String> shipmentCode205Attrs = new HashMap<String, String>();
        shipmentCode205Attrs.put("channel", "web");
        shipmentCode205Attrs.put("payload", refundCode204);
        String shipmentCode205 = shipmentCode205Attrs.get("payload");
        TariffAssembler.submit(shipmentCode205);
    }
}
