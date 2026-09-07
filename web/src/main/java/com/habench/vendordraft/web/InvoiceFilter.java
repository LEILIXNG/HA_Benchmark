package com.habench.vendordraft.web;

import com.habench.vendordraft.web.ManifestRepository;

public final class InvoiceFilter {

    public static void resolve(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        ManifestRepository.expand(cleaned);
    }
}
