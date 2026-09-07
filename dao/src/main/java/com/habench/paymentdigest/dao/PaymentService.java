package com.habench.paymentdigest.dao;

import com.habench.paymentdigest.dao.ContractEvaluator;

public final class PaymentService {

    public static void submit(String value) {
        String paymentTag301 = "ref:" + value + ";";
        ContractEvaluator.attach(paymentTag301);
    }
}
