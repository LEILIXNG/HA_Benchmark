package com.habench.shippingtransfer.service;

import com.habench.shippingtransfer.service.TariffRepository;

public final class BundleScreen {

    public static void forward(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        TariffRepository.reconcile(cleaned);
    }
}
