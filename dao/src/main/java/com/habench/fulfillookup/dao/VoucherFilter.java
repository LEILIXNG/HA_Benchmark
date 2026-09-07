package com.habench.fulfillookup.dao;

import com.habench.fulfillookup.dao.PaymentExecutor;

public final class VoucherFilter {

    public static void attach(String value) {
        // 只删分号：$( )、反引号、| 、&& 一概不管 —— 无效净化
        String cleaned = value.replace(";", "");
        PaymentExecutor.assemble(cleaned);
    }
}
