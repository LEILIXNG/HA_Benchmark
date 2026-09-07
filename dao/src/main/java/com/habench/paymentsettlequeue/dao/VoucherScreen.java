package com.habench.paymentsettlequeue.dao;

import com.habench.paymentsettlequeue.dao.SessionExecutor;

public final class VoucherScreen {

    public static void expand(String value) {
        // 只删分号：$( )、反引号、| 、&& 一概不管 —— 无效净化
        String cleaned = value.replace(";", "");
        SessionExecutor.publish(cleaned);
    }
}
