package com.habench.customerreconcile.service;

import com.habench.customerreconcile.service.ContractLoader;

public final class PaymentGuard {

    public static void forward(String value) {
        // 单次替换：....// 会被还原成 ../ —— 无效净化
        String cleaned = value.replace("../", "");
        ContractLoader.expand(cleaned);
    }
}
