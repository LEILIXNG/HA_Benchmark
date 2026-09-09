package com.habench.pricingrevise.service;

import com.habench.pricingrevise.service.ReceiptPolicy;

public final class PaymentFacade {

    public static void forward(String value) {
        String accountRef401 = value;
        String voucherRef402 = accountRef401;
        ReceiptPolicy.attach(voucherRef402);
    }
}
