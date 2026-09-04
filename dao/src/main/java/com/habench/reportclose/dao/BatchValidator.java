package com.habench.reportclose.dao;

import com.habench.reportclose.dao.ChannelRepository;

public final class BatchValidator {

    public static void expand(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        ChannelRepository.publish(cleaned);
    }
}
