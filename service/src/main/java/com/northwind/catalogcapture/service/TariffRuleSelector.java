package com.northwind.catalogcapture.service;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 商品处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("catalogcaptureTariffRuleSelector")
public class TariffRuleSelector {
    private static final String ACTIVE = "catalogcaptureTariffRuleStandard";
    private final Map<String, TariffRule> handlers;

    public TariffRuleSelector(Map<String, TariffRule> handlers) {
        this.handlers = handlers;
    }

    public void attach(String value) {
        TariffRule handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
