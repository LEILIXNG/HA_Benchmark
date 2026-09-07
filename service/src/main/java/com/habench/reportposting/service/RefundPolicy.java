package com.habench.reportposting.service;

import com.habench.reportposting.service.ManifestRepository;

public final class RefundPolicy {

    public static void route(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        ManifestRepository.submit(cleaned);
    }
}
