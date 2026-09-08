package com.habench.accountdigest.web;

import com.habench.accountdigest.web.TariffGateway;

public final class RefundScreen {

    public static void assemble(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        TariffGateway.route(cleaned);
    }
}
