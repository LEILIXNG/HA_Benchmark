package com.habench.pricingreconcile.dao;

import com.habench.pricingreconcile.dao.VoucherExecutor;

public final class RefundGuard {

    public static void expand(String value) {
        // 只删分号：$( )、反引号、| 、&& 一概不管 —— 无效净化
        String cleaned = value.replace(";", "");
        VoucherExecutor.dispatch(cleaned);
    }
}
