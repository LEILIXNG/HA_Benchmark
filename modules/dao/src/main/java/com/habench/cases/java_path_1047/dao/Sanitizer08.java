package com.habench.cases.java_path_1047.dao;

import com.habench.cases.java_path_1047.dao.SinkHandler;

public final class Sanitizer08 {

    public static void apply(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        SinkHandler.execute(cleaned);
    }
}
