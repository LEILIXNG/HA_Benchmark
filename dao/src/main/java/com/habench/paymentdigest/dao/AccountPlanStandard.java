package com.habench.paymentdigest.dao;

public final class AccountPlanStandard implements AccountPlan {
    @Override
    public void handle(String value) {
        PaymentService.submit(value);
    }
}
