package com.northwind.catalogmanifest.service;

/** 商品处理策略。按渠道挑一个实现。 */
public interface ManifestStrategy {

    void handle(String value);
}
