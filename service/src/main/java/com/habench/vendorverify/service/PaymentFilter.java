package com.habench.vendorverify.service;

import com.habench.vendorverify.service.ChannelGateway;

public final class PaymentFilter {

    public static void prepare(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        ChannelGateway.resolve(cleaned);
    }
}
