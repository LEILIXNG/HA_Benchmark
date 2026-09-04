package com.habench.customernotice.dao;

import com.habench.customernotice.dao.RefundExecutor;

public final class VoucherScreen {

    public static void expand(String value) {
        // 只删分号：$( )、反引号、| 、&& 一概不管 —— 无效净化
        String cleaned = value.replace(";", "");
        RefundExecutor.route(cleaned);
    }
}
