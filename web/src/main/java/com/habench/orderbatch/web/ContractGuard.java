package com.habench.orderbatch.web;

import com.habench.orderbatch.web.OrderEvaluator;

public final class ContractGuard {

    public static void assemble(String value) {
        // 只删 T( ：TT(( 单次替换后会被还原成 T( —— 无效净化
        String cleaned = value.replace("T(", "");
        OrderEvaluator.submit(cleaned);
    }
}
