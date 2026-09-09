package com.northwind.billingdraft.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 账务处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("billingdraftBundlePolicySelector")
public class BundlePolicySelector {
    private static final String ACTIVE = "billingdraftBundlePolicyStandard";
    private final Map<String, BundlePolicy> handlers;

    public BundlePolicySelector(Map<String, BundlePolicy> handlers) {
        this.handlers = handlers;
    }

    public void prepare(String value) {
        BundlePolicy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
