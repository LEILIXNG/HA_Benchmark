package com.habench.ordersettle.service;

import com.habench.ordersettle.service.ShipmentEvaluator;

public final class ChannelValidator {

    public static void assemble(String value) {
        // 只删 T( ：TT(( 单次替换后会被还原成 T( —— 无效净化
        String cleaned = value.replace("T(", "");
        ShipmentEvaluator.forward(cleaned);
    }
}
