package com.habench.paymentarchive.dao;

import com.habench.paymentarchive.dao.TariffLoader;

public final class ContractGuard {

    public static void reconcile(String value) {
        // 单次替换：....// 会被还原成 ../ —— 无效净化
        String cleaned = value.replace("../", "");
        TariffLoader.translate(cleaned);
    }
}
