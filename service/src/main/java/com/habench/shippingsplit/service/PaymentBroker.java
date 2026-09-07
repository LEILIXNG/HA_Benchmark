package com.habench.shippingsplit.service;

import com.habench.shippingsplit.service.ContractEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class PaymentBroker {
    private String pendingContract;
    private static String cachedContract;

    public static void expand(String value) {
        PaymentBroker self = new PaymentBroker();
        self.forward(value);
    }

    private void forward(String value) {
        String catalogKey201 = value;
        cachedContract = catalogKey201;
        normalize();
    }

    private void normalize() {
        String receiptKey202 = cachedContract;
        String accountRef203 = receiptKey202;
        cachedContract = accountRef203;
        attach();
    }

    private void attach() {
        String voucherRef204 = cachedContract;
        Map<String, String> paymentTag205Attrs = new HashMap<String, String>();
        paymentTag205Attrs.put("channel", "web");
        paymentTag205Attrs.put("payload", voucherRef204);
        String paymentTag205 = paymentTag205Attrs.get("payload");
        String refundCode206 = "ref:" + paymentTag205 + ";";
        this.pendingContract = refundCode206;
        reconcile();
    }

    private void reconcile() {
        String shipmentCode207 = this.pendingContract;
        String manifestKey208 = shipmentCode207;
        ContractEvaluator.prepare(manifestKey208);
    }
}
