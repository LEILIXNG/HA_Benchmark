package com.habench.vendorissue.web;

import com.habench.vendorissue.web.PaymentLoader;

public final class TariffScreen {

    public static void submit(String value) {
        // 单次替换：....// 会被还原成 ../ —— 无效净化
        String cleaned = value.replace("../", "");
        PaymentLoader.collect(cleaned);
    }
}
