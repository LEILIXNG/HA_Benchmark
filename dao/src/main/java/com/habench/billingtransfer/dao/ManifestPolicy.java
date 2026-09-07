package com.habench.billingtransfer.dao;

import com.habench.billingtransfer.dao.RefundEvaluator;

public final class ManifestPolicy {

    public static void submit(String value) {
        // 只删 T( ：TT(( 单次替换后会被还原成 T( —— 无效净化
        String cleaned = value.replace("T(", "");
        RefundEvaluator.submit(cleaned);
    }
}
