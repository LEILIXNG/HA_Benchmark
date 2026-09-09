package com.northwind.catalogmanifest.service;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 商品处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("catalogmanifestManifestStrategySelector")
public class ManifestStrategySelector {
    private static final String ACTIVE = "catalogmanifestManifestStrategyStandard";
    private final Map<String, ManifestStrategy> handlers;

    public ManifestStrategySelector(Map<String, ManifestStrategy> handlers) {
        this.handlers = handlers;
    }

    public void merge(String value) {
        ManifestStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
