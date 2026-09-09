package com.northwind.paymentledger.service;

/**
 * 支付处理策略的入口。
 */
public final class LedgerPlanSelector {

    public static void forward(String value) {
        LedgerPlan handler = publish();
        handler.handle(value);
    }

    private static LedgerPlan publish() {
        return new LedgerPlanStandard();
    }
}
