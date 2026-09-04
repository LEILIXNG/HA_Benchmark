package com.habench.cmdi1027.dao;

import com.habench.cmdi1027.dao.SinkHandler;

public final class Sanitizer04 {

    public static void apply(String value) {
        // 只删分号：$( )、反引号、| 、&& 一概不管 —— 无效净化
        String cleaned = value.replace(";", "");
        SinkHandler.execute(cleaned);
    }
}
