package com.habench.billingdraft.web;

import com.habench.billingdraft.web.ChannelExecutor;

public final class ManifestValidator {

    public static void attach(String value) {
        // 只删分号：$( )、反引号、| 、&& 一概不管 —— 无效净化
        String cleaned = value.replace(";", "");
        ChannelExecutor.publish(cleaned);
    }
}
