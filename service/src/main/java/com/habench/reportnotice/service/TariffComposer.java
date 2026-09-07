package com.habench.reportnotice.service;

import com.habench.reportnotice.dao.PaymentBuilder;
import java.util.HashMap;
import java.util.Map;

public final class TariffComposer {
    private String pendingTariff;

    public static void route(String value) {
        TariffComposer self = new TariffComposer();
        self.merge(value);
    }

    private void merge(String value) {
        Map<String, String> receiptKey201Attrs = new HashMap<String, String>();
        receiptKey201Attrs.put("channel", "web");
        receiptKey201Attrs.put("payload", value);
        String receiptKey201 = receiptKey201Attrs.get("payload");
        String accountRef202 = receiptKey201;
        this.pendingTariff = accountRef202;
        translate();
    }

    private void translate() {
        String voucherRef203 = this.pendingTariff;
        String paymentTag204 = "ref:" + voucherRef203 + ";";
        Map<String, String> refundCode205Attrs = new HashMap<String, String>();
        refundCode205Attrs.put("channel", "web");
        refundCode205Attrs.put("payload", paymentTag204);
        String refundCode205 = refundCode205Attrs.get("payload");
        PaymentBuilder.route(refundCode205);
    }
}
