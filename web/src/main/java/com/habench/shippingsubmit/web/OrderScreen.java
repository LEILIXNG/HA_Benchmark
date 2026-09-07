package com.habench.shippingsubmit.web;

import com.habench.shippingsubmit.web.SessionEvaluator;

public final class OrderScreen {

    public static void resolve(String value) {
        // 只删 T( ：TT(( 单次替换后会被还原成 T( —— 无效净化
        String cleaned = value.replace("T(", "");
        SessionEvaluator.refine(cleaned);
    }
}
