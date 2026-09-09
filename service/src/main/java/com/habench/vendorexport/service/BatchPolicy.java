package com.habench.vendorexport.service;

import com.habench.vendorexport.service.ChannelRepository;

public final class BatchPolicy {

    public static void refine(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        ChannelRepository.reconcile(cleaned);
    }
}
