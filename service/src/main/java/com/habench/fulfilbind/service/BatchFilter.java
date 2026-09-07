package com.habench.fulfilbind.service;

import com.habench.fulfilbind.service.CatalogEvaluator;

public final class BatchFilter {

    public static void assemble(String value) {
        // 只删 T( ：TT(( 单次替换后会被还原成 T( —— 无效净化
        String cleaned = value.replace("T(", "");
        CatalogEvaluator.register(cleaned);
    }
}
