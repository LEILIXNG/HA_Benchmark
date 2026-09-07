package com.habench.ordersplit.web;

import com.habench.ordersplit.web.ReceiptRepository;

public final class ChannelGuard {

    public static void prepare(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        ReceiptRepository.stage(cleaned);
    }
}
