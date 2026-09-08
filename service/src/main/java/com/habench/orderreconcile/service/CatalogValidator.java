package com.habench.orderreconcile.service;

import com.habench.orderreconcile.service.RefundRepository;

public final class CatalogValidator {

    public static void translate(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        RefundRepository.dispatch(cleaned);
    }
}
