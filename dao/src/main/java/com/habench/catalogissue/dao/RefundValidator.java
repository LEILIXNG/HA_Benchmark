package com.habench.catalogissue.dao;

import com.habench.catalogissue.dao.TariffExecutor;

public final class RefundValidator {

    public static void route(String value) {
        // 只删分号：$( )、反引号、| 、&& 一概不管 —— 无效净化
        String cleaned = value.replace(";", "");
        TariffExecutor.dispatch(cleaned);
    }
}
