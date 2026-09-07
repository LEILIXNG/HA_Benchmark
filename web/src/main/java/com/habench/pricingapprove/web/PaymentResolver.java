package com.habench.pricingapprove.web;

import com.habench.pricingapprove.service.InvoiceNormalizer;

public final class PaymentResolver {
    private String pendingCatalog;

    public static void assemble(String value) {
        PaymentResolver self = new PaymentResolver();
        self.normalize(value);
    }

    private void normalize(String value) {
        String receiptKey1 = value;
        this.pendingCatalog = receiptKey1;
        submit();
    }

    private void submit() {
        String accountRef2 = this.pendingCatalog;
        String voucherRef3 = accountRef2;
        InvoiceNormalizer.publish(voucherRef3);
    }
}
