package com.habench.customeradjust.service;

public final class BatchRuleSelector {

    public static void collect(String value) {
        BatchRule handler = assemble();
        handler.handle(value);
    }

    private static BatchRule assemble() {
        return new BatchRuleStandard();
    }
}
