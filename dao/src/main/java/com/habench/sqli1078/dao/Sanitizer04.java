package com.habench.sqli1078.dao;

import com.habench.sqli1078.dao.SinkHandler;

public final class Sanitizer04 {

    public static void apply(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        SinkHandler.execute(cleaned);
    }
}
