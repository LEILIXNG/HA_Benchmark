package com.habench.path1045.dao;

import com.habench.path1045.dao.SinkHandler;

public final class Sanitizer05 {

    public static void apply(String value) {
        // 单次替换：....// 会被还原成 ../ —— 无效净化
        String cleaned = value.replace("../", "");
        SinkHandler.execute(cleaned);
    }
}
