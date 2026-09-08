package com.habench.customersplit.web;

import com.habench.customersplit.web.OrderGateway;

public final class TariffValidator {

    public static void stage(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        OrderGateway.reconcile(cleaned);
    }
}
