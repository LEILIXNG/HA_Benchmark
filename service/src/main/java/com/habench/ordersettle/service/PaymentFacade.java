package com.habench.ordersettle.service;

import com.habench.ordersettle.service.PaymentLoader;
import java.util.HashMap;
import java.util.Map;

public final class PaymentFacade {
    private String pendingPayment;

    public static void attach(String value) {
        PaymentFacade self = new PaymentFacade();
        self.merge(value);
    }

    private void merge(String value) {
        String batchTag201 = "ref:" + value + ";";
        Map<String, String> orderRef202Attrs = new HashMap<String, String>();
        orderRef202Attrs.put("channel", "web");
        orderRef202Attrs.put("payload", batchTag201);
        String orderRef202 = orderRef202Attrs.get("payload");
        this.pendingPayment = orderRef202;
        expand();
    }

    private void expand() {
        String quoteRef203 = this.pendingPayment;
        Map<String, String> tariffRef204Attrs = new HashMap<String, String>();
        tariffRef204Attrs.put("channel", "web");
        tariffRef204Attrs.put("payload", quoteRef203);
        String tariffRef204 = tariffRef204Attrs.get("payload");
        PaymentLoader.normalize(tariffRef204);
    }
}
