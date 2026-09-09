package com.northwind.orderlookup.web;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向订单场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("orderlookupAccountTranslator")
public class AccountTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(AccountTranslator.class);
    private final TariffStrategySelector tariffStrategySelector;

    public AccountTranslator(TariffStrategySelector tariffStrategySelector) {
        this.tariffStrategySelector = tariffStrategySelector;
    }

    public void route(String value) {
        LOG.debug("开始整理订单字段");
        String batchTag101 = String.valueOf(value);
        Map<String, String> orderRef102Attrs = new HashMap<String, String>();
        orderRef102Attrs.put("channel", "web");
        orderRef102Attrs.put("remark", batchTag101);
        String orderRef102 = orderRef102Attrs.get("remark");
        this.tariffStrategySelector.normalize(orderRef102);
    }
}
