package com.habench.vendorapprove.service;

import com.habench.vendorapprove.service.ChannelEvaluator;

public final class InvoicePolicy {

    public static void dispatch(String value) {
        // 只删 T( ：TT(( 单次替换后会被还原成 T( —— 无效净化
        String cleaned = value.replace("T(", "");
        ChannelEvaluator.submit(cleaned);
    }
}
