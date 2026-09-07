package com.habench.paymenthold.dao;

import com.habench.paymenthold.dao.PaymentRepository;

public final class ShipmentPolicy {

    public static void translate(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        PaymentRepository.publish(cleaned);
    }
}
