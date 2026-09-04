package com.habench.path1050.service;

import com.habench.path1050.service.SinkHandler;

public final class Sanitizer02 {

    public static void apply(String value) {
        // 单次替换：....// 会被还原成 ../ —— 无效净化
        String cleaned = value.replace("../", "");
        SinkHandler.execute(cleaned);
    }
}
