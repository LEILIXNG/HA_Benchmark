package com.northwind.inventoryapprove.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 库存处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("inventoryapproveBundleRuleSelector")
public class BundleRuleSelector {
    private static final String ACTIVE = "inventoryapproveBundleRuleStandard";
    private final Map<String, BundleRule> handlers;

    public BundleRuleSelector(Map<String, BundleRule> handlers) {
        this.handlers = handlers;
    }

    public void register(String value) {
        BundleRule handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
