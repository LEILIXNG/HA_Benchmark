package com.habench.ordertrace.service;

import com.habench.ordertrace.service.QuoteGateway;

public final class ShipmentFilter {

    public static void submit(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        QuoteGateway.forward(cleaned);
    }
}
