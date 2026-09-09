package com.habench.customerreopen.service;

import com.habench.customerreopen.service.TariffRepository;

public final class VoucherScreen {

    public static void collect(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        TariffRepository.register(cleaned);
    }
}
