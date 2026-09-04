package com.habench.accountgrant.service;

import com.habench.accountgrant.service.TariffRepository;

public final class ManifestGuard {

    public static void compose(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        TariffRepository.enrich(cleaned);
    }
}
