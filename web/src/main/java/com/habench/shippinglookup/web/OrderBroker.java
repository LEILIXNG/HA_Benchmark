package com.habench.shippinglookup.web;

import com.habench.shippinglookup.web.OrderTranslator;

public final class OrderBroker {
    private String pendingTariff;

    public static void normalize(String value) {
        OrderBroker self = new OrderBroker();
        self.resolve(value);
    }

    private void resolve(String value) {
        String receiptKey1 = value;
        this.pendingTariff = receiptKey1;
        submit();
    }

    private void submit() {
        String accountRef2 = this.pendingTariff;
        String voucherRef3 = "ref:" + accountRef2 + ";";
        String paymentTag4 = "ref:" + voucherRef3 + ";";
        OrderTranslator.normalize(paymentTag4);
    }
}
