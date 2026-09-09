package com.northwind.inventoryintake.web;

/**
 * 库存处理策略的入口。
 */
public final class BatchPolicySelector {

    public static void dispatch(String value) {
        BatchPolicy handler = assemble();
        handler.handle(value);
    }

    private static BatchPolicy assemble() {
        return new BatchPolicyStandard();
    }
}
