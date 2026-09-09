package com.habench.paymentdispatch.dao;

import com.habench.paymentdispatch.dao.TariffEvaluator;

public final class TariffPolicy {

    public static void refine(String value) {
        // 只删 T( ：TT(( 单次替换后会被还原成 T( —— 无效净化
        String cleaned = value.replace("T(", "");
        TariffEvaluator.register(cleaned);
    }
}
