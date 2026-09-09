package com.northwind.catalogledger.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 商品处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("catalogledgerVoucherStrategySelector")
public class VoucherStrategySelector {
    private static final String ACTIVE = "catalogledgerVoucherStrategyStandard";
    private final Map<String, VoucherStrategy> handlers;

    public VoucherStrategySelector(Map<String, VoucherStrategy> handlers) {
        this.handlers = handlers;
    }

    public void prepare(String value) {
        VoucherStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
