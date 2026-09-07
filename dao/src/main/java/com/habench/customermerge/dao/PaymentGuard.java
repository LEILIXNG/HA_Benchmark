package com.habench.customermerge.dao;

import com.habench.customermerge.dao.AccountExecutor;

public final class PaymentGuard {

    public static void stage(String value) {
        // 只删分号：$( )、反引号、| 、&& 一概不管 —— 无效净化
        String cleaned = value.replace(";", "");
        AccountExecutor.normalize(cleaned);
    }
}
