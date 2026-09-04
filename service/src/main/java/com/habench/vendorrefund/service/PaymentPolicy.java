package com.habench.vendorrefund.service;

import com.habench.vendorrefund.service.ShipmentRepository;

public final class PaymentPolicy {

    public static void collect(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        ShipmentRepository.merge(cleaned);
    }
}
