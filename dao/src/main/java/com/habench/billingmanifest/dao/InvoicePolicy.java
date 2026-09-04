package com.habench.billingmanifest.dao;

import com.habench.billingmanifest.dao.ChannelRepository;

public final class InvoicePolicy {

    public static void route(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        ChannelRepository.publish(cleaned);
    }
}
