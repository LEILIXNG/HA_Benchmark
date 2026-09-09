package com.northwind.accountsettlequeue.dao;

import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 账户处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Repository("accountsettlequeueLedgerStrategySelector")
public class LedgerStrategySelector {
    private static final String ACTIVE = "accountsettlequeueLedgerStrategyStandard";
    private final Map<String, LedgerStrategy> handlers;

    public LedgerStrategySelector(Map<String, LedgerStrategy> handlers) {
        this.handlers = handlers;
    }

    public void normalize(String value) {
        LedgerStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
