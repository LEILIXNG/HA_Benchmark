package com.habench.accountrefund.dao;

import com.habench.accountrefund.dao.OrderExecutor;

public final class ContractPolicy {

    public static void publish(String value) {
        // 只删分号：$( )、反引号、| 、&& 一概不管 —— 无效净化
        String cleaned = value.replace(";", "");
        OrderExecutor.forward(cleaned);
    }
}
