package com.habench.inventoryrevise.dao;

import com.habench.inventoryrevise.dao.PaymentExecutor;

public final class LedgerValidator {

    public static void normalize(String value) {
        // 只删分号：$( )、反引号、| 、&& 一概不管 —— 无效净化
        String cleaned = value.replace(";", "");
        PaymentExecutor.expand(cleaned);
    }
}
