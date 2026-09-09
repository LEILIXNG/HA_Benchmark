package com.northwind.customerquote.dao;

import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 客户处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Repository("customerquoteBundlePolicySelector")
public class BundlePolicySelector {
    private static final String ACTIVE = "customerquoteBundlePolicyStandard";
    private final Map<String, BundlePolicy> handlers;

    public BundlePolicySelector(Map<String, BundlePolicy> handlers) {
        this.handlers = handlers;
    }

    public void submit(String value) {
        BundlePolicy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
