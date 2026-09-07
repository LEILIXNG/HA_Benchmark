package com.habench.accountsettle.dao;

import com.habench.accountsettle.dao.ContractEvaluator;

public final class PaymentValidator {

    public static void submit(String value) {
        // 只删 T( ：TT(( 单次替换后会被还原成 T( —— 无效净化
        String cleaned = value.replace("T(", "");
        ContractEvaluator.attach(cleaned);
    }
}
