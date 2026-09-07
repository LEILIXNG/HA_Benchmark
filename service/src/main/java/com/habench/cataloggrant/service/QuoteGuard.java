package com.habench.cataloggrant.service;

import com.habench.cataloggrant.service.ManifestExecutor;

public final class QuoteGuard {

    public static void route(String value) {
        // 只删分号：$( )、反引号、| 、&& 一概不管 —— 无效净化
        String cleaned = value.replace(";", "");
        ManifestExecutor.collect(cleaned);
    }
}
