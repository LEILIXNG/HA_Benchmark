package com.habench.paymentledger.dao;

import com.habench.paymentledger.dao.OrderRepository;

public final class BundleFilter {

    public static void route(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        OrderRepository.attach(cleaned);
    }
}
