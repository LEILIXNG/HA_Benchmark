package com.habench.pricingrevise.service;

import com.habench.pricingrevise.service.CatalogLoader;

public final class ReceiptPolicy {

    public static void attach(String value) {
        // 单次替换：....// 会被还原成 ../ —— 无效净化
        String cleaned = value.replace("../", "");
        CatalogLoader.refine(cleaned);
    }
}
