package com.habench.customerassign.dao;

import com.habench.customerassign.dao.BundleLoader;

public final class CatalogScreen {

    public static void reconcile(String value) {
        // 单次替换：....// 会被还原成 ../ —— 无效净化
        String cleaned = value.replace("../", "");
        BundleLoader.compose(cleaned);
    }
}
