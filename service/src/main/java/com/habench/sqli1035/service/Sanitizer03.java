package com.habench.sqli1035.service;

import com.habench.sqli1035.service.SinkHandler;

public final class Sanitizer03 {

    public static void apply(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        SinkHandler.execute(cleaned);
    }
}
