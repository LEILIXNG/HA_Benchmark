package com.habench.fulfilrelease.dao;

import com.habench.fulfilrelease.dao.VoucherEvaluator;

public final class ContractFilter {

    public static void stage(String value) {
        // 只删 T( ：TT(( 单次替换后会被还原成 T( —— 无效净化
        String cleaned = value.replace("T(", "");
        VoucherEvaluator.enrich(cleaned);
    }
}
