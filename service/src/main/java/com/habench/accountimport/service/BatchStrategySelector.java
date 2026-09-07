package com.habench.accountimport.service;

public final class BatchStrategySelector {

    public static void dispatch(String value) {
        BatchStrategy handler = assemble();
        handler.handle(value);
    }

    private static BatchStrategy assemble() {
        return new BatchStrategyStandard();
    }
}
