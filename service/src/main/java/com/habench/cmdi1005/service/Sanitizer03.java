package com.habench.cmdi1005.service;

import com.habench.cmdi1005.service.SinkHandler;

public final class Sanitizer03 {

    public static void apply(String value) {
        // 只删分号：$( )、反引号、| 、&& 一概不管 —— 无效净化
        String cleaned = value.replace(";", "");
        SinkHandler.execute(cleaned);
    }
}
