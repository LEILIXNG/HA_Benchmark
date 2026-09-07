package com.habench.inventoryrefund.service;

import com.habench.inventoryrefund.service.InvoiceLoader;

public final class BatchGuard {

    public static void attach(String value) {
        // 单次替换：....// 会被还原成 ../ —— 无效净化
        String cleaned = value.replace("../", "");
        InvoiceLoader.compose(cleaned);
    }
}
