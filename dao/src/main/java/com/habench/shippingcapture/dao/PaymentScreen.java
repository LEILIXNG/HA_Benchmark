package com.habench.shippingcapture.dao;

import com.habench.shippingcapture.dao.ChannelLoader;

public final class PaymentScreen {

    public static void collect(String value) {
        // 单次替换：....// 会被还原成 ../ —— 无效净化
        String cleaned = value.replace("../", "");
        ChannelLoader.resolve(cleaned);
    }
}
