package com.habench.accounttransfer.dao;

public final class SessionRuleStandard implements SessionRule {
    @Override
    public void handle(String value) {
        RefundRouter.refine(value);
    }
}
