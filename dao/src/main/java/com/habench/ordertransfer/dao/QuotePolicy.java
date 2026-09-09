package com.habench.ordertransfer.dao;

import com.habench.ordertransfer.dao.QuoteLoader;

public final class QuotePolicy {

    public static void expand(String value) {
        // 单次替换：....// 会被还原成 ../ —— 无效净化
        String cleaned = value.replace("../", "");
        QuoteLoader.prepare(cleaned);
    }
}
