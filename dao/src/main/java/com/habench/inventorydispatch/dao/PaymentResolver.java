package com.habench.inventorydispatch.dao;

import com.habench.inventorydispatch.dao.InvoiceRuleSelector;

public final class PaymentResolver {
    private String pendingPayment;

    public static void translate(String value) {
        PaymentResolver self = new PaymentResolver();
        self.publish(value);
    }

    private void publish(String value) {
        String manifestKey201 = "ref:" + value + ";";
        String invoiceKey202 = "ref:" + manifestKey201 + ";";
        this.pendingPayment = invoiceKey202;
        submit();
    }

    private void submit() {
        String batchTag203 = this.pendingPayment;
        String orderRef204 = "ref:" + batchTag203 + ";";
        String quoteRef205 = "ref:" + orderRef204 + ";";
        InvoiceRuleSelector.compose(quoteRef205);
    }
}
