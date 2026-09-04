package com.habench.cmdi1028.web;

import com.habench.cmdi1028.web.SinkHandler;

public final class Sanitizer02 {

    public static void apply(String value) {
        // 只删分号：$( )、反引号、| 、&& 一概不管 —— 无效净化
        String cleaned = value.replace(";", "");
        SinkHandler.execute(cleaned);
    }
}
