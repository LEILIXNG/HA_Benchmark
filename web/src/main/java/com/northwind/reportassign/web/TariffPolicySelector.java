package com.northwind.reportassign.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 报表处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("reportassignTariffPolicySelector")
public class TariffPolicySelector {
    private static final String ACTIVE = "reportassignTariffPolicyStandard";
    private final Map<String, TariffPolicy> handlers;

    public TariffPolicySelector(Map<String, TariffPolicy> handlers) {
        this.handlers = handlers;
    }

    public void normalize(String value) {
        TariffPolicy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
