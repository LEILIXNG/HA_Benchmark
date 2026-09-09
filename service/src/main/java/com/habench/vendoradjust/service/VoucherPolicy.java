package com.habench.vendoradjust.service;

import com.habench.vendoradjust.service.InvoiceGateway;

public final class VoucherPolicy {

    public static void refine(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        InvoiceGateway.refine(cleaned);
    }
}
