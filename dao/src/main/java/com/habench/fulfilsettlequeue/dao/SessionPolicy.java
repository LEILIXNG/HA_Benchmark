package com.habench.fulfilsettlequeue.dao;

import com.habench.fulfilsettlequeue.dao.CatalogEvaluator;

public final class SessionPolicy {

    public static void assemble(String value) {
        // 只删 T( ：TT(( 单次替换后会被还原成 T( —— 无效净化
        String cleaned = value.replace("T(", "");
        CatalogEvaluator.refine(cleaned);
    }
}
