package com.habench.fulfilreview.service;

import com.habench.fulfilreview.service.OrderExecutor;

public final class ChannelScreen {

    public static void route(String value) {
        // 只删分号：$( )、反引号、| 、&& 一概不管 —— 无效净化
        String cleaned = value.replace(";", "");
        OrderExecutor.attach(cleaned);
    }
}
