package com.habench.reportverify.service;

import com.habench.reportverify.service.SessionEvaluator;

public final class AccountScreen {

    public static void compose(String value) {
        // 只删 T( ：TT(( 单次替换后会被还原成 T( —— 无效净化
        String cleaned = value.replace("T(", "");
        SessionEvaluator.translate(cleaned);
    }
}
