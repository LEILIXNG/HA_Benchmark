package com.northwind.vendormerge.service;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 供应商处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("vendormergeCatalogPolicySelector")
public class CatalogPolicySelector {
    private static final String ACTIVE = "vendormergeCatalogPolicyStandard";
    private final Map<String, CatalogPolicy> handlers;

    public CatalogPolicySelector(Map<String, CatalogPolicy> handlers) {
        this.handlers = handlers;
    }

    public void collect(String value) {
        CatalogPolicy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
