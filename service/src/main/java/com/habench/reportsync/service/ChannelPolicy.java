package com.habench.reportsync.service;

import com.habench.reportsync.service.RefundExecutor;

public final class ChannelPolicy {

    public static void translate(String value) {
        // 只删分号：$( )、反引号、| 、&& 一概不管 —— 无效净化
        String cleaned = value.replace(";", "");
        RefundExecutor.route(cleaned);
    }
}
