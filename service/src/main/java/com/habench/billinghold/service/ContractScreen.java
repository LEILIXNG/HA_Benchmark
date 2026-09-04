package com.habench.billinghold.service;

import com.habench.billinghold.service.ReceiptExecutor;

public final class ContractScreen {

    public static void attach(String value) {
        // 只删分号：$( )、反引号、| 、&& 一概不管 —— 无效净化
        String cleaned = value.replace(";", "");
        ReceiptExecutor.forward(cleaned);
    }
}
