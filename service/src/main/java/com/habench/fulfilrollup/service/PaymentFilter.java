package com.habench.fulfilrollup.service;

import com.habench.fulfilrollup.service.QuoteRepository;

public final class PaymentFilter {

    public static void route(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        QuoteRepository.register(cleaned);
    }
}
