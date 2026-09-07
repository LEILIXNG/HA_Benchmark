package com.habench.reportbind.service;

import com.habench.reportbind.service.ContractLoader;

public final class LedgerPolicy {

    public static void reconcile(String value) {
        // 单次替换：....// 会被还原成 ../ —— 无效净化
        String cleaned = value.replace("../", "");
        ContractLoader.register(cleaned);
    }
}
