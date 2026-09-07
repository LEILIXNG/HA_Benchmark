package com.habench.billingreopen.dao;

import com.habench.billingreopen.dao.ChannelRepository;

public final class BundleValidator {

    public static void submit(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        ChannelRepository.compose(cleaned);
    }
}
