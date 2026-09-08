package com.habench.paymentadjust.web;

import com.habench.paymentadjust.web.BundleGateway;

public final class InvoicePolicy {

    public static void resolve(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        BundleGateway.dispatch(cleaned);
    }
}
