package com.habench.orderrefund.dao;

import com.habench.orderrefund.dao.PaymentLoader;

public final class PaymentPolicy {

    public static void attach(String value) {
        // 单次替换：....// 会被还原成 ../ —— 无效净化
        String cleaned = value.replace("../", "");
        PaymentLoader.reconcile(cleaned);
    }
}
