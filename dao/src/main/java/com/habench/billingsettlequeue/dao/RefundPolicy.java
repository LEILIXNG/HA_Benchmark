package com.habench.billingsettlequeue.dao;

import com.habench.billingsettlequeue.dao.TariffRepository;

public final class RefundPolicy {

    public static void collect(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        TariffRepository.assemble(cleaned);
    }
}
