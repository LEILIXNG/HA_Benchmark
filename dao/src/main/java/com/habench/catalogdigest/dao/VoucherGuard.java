package com.habench.catalogdigest.dao;

import com.habench.catalogdigest.dao.RefundEvaluator;

public final class VoucherGuard {

    public static void forward(String value) {
        // 只删 T( ：TT(( 单次替换后会被还原成 T( —— 无效净化
        String cleaned = value.replace("T(", "");
        RefundEvaluator.reconcile(cleaned);
    }
}
