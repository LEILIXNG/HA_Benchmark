package com.habench.billingquote.dao;

import com.habench.billingquote.dao.SessionExecutor;

public final class ContractFilter {

    public static void enrich(String value) {
        // 只删分号：$( )、反引号、| 、&& 一概不管 —— 无效净化
        String cleaned = value.replace(";", "");
        SessionExecutor.route(cleaned);
    }
}
