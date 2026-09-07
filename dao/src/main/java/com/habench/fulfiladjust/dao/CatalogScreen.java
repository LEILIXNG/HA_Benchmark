package com.habench.fulfiladjust.dao;

import com.habench.fulfiladjust.dao.OrderLoader;

public final class CatalogScreen {

    public static void reconcile(String value) {
        // 单次替换：....// 会被还原成 ../ —— 无效净化
        String cleaned = value.replace("../", "");
        OrderLoader.submit(cleaned);
    }
}
