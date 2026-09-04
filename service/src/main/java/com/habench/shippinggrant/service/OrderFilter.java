package com.habench.shippinggrant.service;

import com.habench.shippinggrant.service.CatalogRepository;

public final class OrderFilter {

    public static void merge(String value) {
        // 只剥离单引号：注释符、关键字、路径分隔符仍可通过 —— 无效净化
        String cleaned = value.replace("'", "");
        CatalogRepository.normalize(cleaned);
    }
}
