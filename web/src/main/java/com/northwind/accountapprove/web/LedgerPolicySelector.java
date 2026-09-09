package com.northwind.accountapprove.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 账户处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("accountapproveLedgerPolicySelector")
public class LedgerPolicySelector {
    private static final String ACTIVE = "accountapproveLedgerPolicyStandard";
    private final Map<String, LedgerPolicy> handlers;

    public LedgerPolicySelector(Map<String, LedgerPolicy> handlers) {
        this.handlers = handlers;
    }

    public void merge(String value) {
        LedgerPolicy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
