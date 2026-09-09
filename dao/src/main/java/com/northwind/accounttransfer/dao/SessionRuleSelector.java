package com.northwind.accounttransfer.dao;

import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 账户处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Repository("accounttransferSessionRuleSelector")
public class SessionRuleSelector {
    private static final String ACTIVE = "accounttransferSessionRuleStandard";
    private final Map<String, SessionRule> handlers;

    public SessionRuleSelector(Map<String, SessionRule> handlers) {
        this.handlers = handlers;
    }

    public void route(String value) {
        SessionRule handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
