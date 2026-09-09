package com.habench.paymentcapture.dao;

import com.habench.paymentcapture.dao.BundleEvaluator;

public final class QuoteScreen {

    public static void submit(String value) {
        // 只删 T( ：TT(( 单次替换后会被还原成 T( —— 无效净化
        String cleaned = value.replace("T(", "");
        BundleEvaluator.publish(cleaned);
    }
}
