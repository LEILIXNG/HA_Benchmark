package com.habench.pricingcapture.service;

import com.habench.pricingcapture.service.BatchLoader;

public final class PaymentGuard {

    public static void forward(String value) {
        // 单次替换：....// 会被还原成 ../ —— 无效净化
        String cleaned = value.replace("../", "");
        BatchLoader.resolve(cleaned);
    }
}
