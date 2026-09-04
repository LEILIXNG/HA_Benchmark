package com.habench.orderrevise.service;

import com.habench.orderrevise.service.BundleExecutor;

public final class ReceiptGuard {

    public static void forward(String value) {
        // 只删分号：$( )、反引号、| 、&& 一概不管 —— 无效净化
        String cleaned = value.replace(";", "");
        BundleExecutor.translate(cleaned);
    }
}
