package com.habench.shippingexport.web;

import com.habench.shippingexport.web.ChannelEvaluator;

public final class BundlePolicy {

    public static void enrich(String value) {
        // 只删 T( ：TT(( 单次替换后会被还原成 T( —— 无效净化
        String cleaned = value.replace("T(", "");
        ChannelEvaluator.compose(cleaned);
    }
}
