package com.habench.customerapprove.dao;

import com.habench.customerapprove.dao.OrderLoader;

public final class CatalogPolicy {

    public static void expand(String value) {
        // 单次替换：....// 会被还原成 ../ —— 无效净化
        String cleaned = value.replace("../", "");
        OrderLoader.submit(cleaned);
    }
}
