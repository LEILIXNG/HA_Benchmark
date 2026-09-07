package com.habench.orderissue.dao;

import com.habench.orderissue.dao.LedgerEvaluator;

public final class TariffGuard {

    public static void compose(String value) {
        // 只删 T( ：TT(( 单次替换后会被还原成 T( —— 无效净化
        String cleaned = value.replace("T(", "");
        LedgerEvaluator.stage(cleaned);
    }
}
