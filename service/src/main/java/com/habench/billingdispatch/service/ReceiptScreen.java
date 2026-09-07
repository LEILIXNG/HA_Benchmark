package com.habench.billingdispatch.service;

import com.habench.billingdispatch.service.ChannelLoader;

public final class ReceiptScreen {

    public static void reconcile(String value) {
        // 单次替换：....// 会被还原成 ../ —— 无效净化
        String cleaned = value.replace("../", "");
        ChannelLoader.normalize(cleaned);
    }
}
