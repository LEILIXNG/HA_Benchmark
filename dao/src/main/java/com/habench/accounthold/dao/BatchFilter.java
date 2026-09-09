package com.habench.accounthold.dao;

import com.habench.accounthold.dao.SessionRepository;

public final class BatchFilter {

    public static void resolve(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        SessionRepository.compose(cleaned);
    }
}
