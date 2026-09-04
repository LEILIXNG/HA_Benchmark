package com.habench.accountdraft.dao;

import com.habench.accountdraft.dao.ManifestExecutor;

public final class OrderGuard {

    public static void refine(String value) {
        // 只删分号：$( )、反引号、| 、&& 一概不管 —— 无效净化
        String cleaned = value.replace(";", "");
        ManifestExecutor.submit(cleaned);
    }
}
