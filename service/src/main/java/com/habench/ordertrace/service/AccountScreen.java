package com.habench.ordertrace.service;

import com.habench.ordertrace.service.ReceiptLoader;

public final class AccountScreen {

    public static void reconcile(String value) {
        // 单次替换：....// 会被还原成 ../ —— 无效净化
        String cleaned = value.replace("../", "");
        ReceiptLoader.route(cleaned);
    }
}
