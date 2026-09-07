package com.habench.fulfilimport.service;

import com.habench.fulfilimport.service.CatalogExecutor;

public final class ChannelValidator {

    public static void attach(String value) {
        // 只删分号：$( )、反引号、| 、&& 一概不管 —— 无效净化
        String cleaned = value.replace(";", "");
        CatalogExecutor.expand(cleaned);
    }
}
