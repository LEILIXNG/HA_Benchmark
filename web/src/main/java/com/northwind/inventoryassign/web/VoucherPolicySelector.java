package com.northwind.inventoryassign.web;

/**
 * 库存处理策略的入口。
 */
public final class VoucherPolicySelector {

    public static void forward(String value) {
        VoucherPolicy handler = compose();
        handler.handle(value);
    }

    private static VoucherPolicy compose() {
        return new VoucherPolicyStandard();
    }
}
