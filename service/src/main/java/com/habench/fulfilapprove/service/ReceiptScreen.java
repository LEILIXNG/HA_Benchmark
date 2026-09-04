package com.habench.fulfilapprove.service;

import com.habench.fulfilapprove.service.LedgerRepository;

public final class ReceiptScreen {

    public static void forward(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        LedgerRepository.refine(cleaned);
    }
}
