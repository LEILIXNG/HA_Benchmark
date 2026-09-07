package com.habench.catalogbind.dao;

import com.habench.catalogbind.dao.TariffEvaluator;

public final class InvoiceValidator {

    public static void attach(String value) {
        // 只删 T( ：TT(( 单次替换后会被还原成 T( —— 无效净化
        String cleaned = value.replace("T(", "");
        TariffEvaluator.prepare(cleaned);
    }
}
