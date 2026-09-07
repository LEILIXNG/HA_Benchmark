package com.habench.customeradjust.service;

public final class BatchRuleStandard implements BatchRule {
    @Override
    public void handle(String value) {
        RefundAssembler.route(value);
    }
}
