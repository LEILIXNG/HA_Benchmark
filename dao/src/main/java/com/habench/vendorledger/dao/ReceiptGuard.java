package com.habench.vendorledger.dao;

import com.habench.vendorledger.dao.BatchRepository;

public final class ReceiptGuard {

    public static void normalize(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        BatchRepository.prepare(cleaned);
    }
}
