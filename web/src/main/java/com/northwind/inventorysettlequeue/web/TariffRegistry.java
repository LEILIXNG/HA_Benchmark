package com.northwind.inventorysettlequeue.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 库存明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("inventorysettlequeueTariffRegistry")
public class TariffRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(TariffRegistry.class);
    private final CatalogPolicySelector catalogPolicySelector;

    public TariffRegistry(CatalogPolicySelector catalogPolicySelector) {
        this.catalogPolicySelector = catalogPolicySelector;
    }

    public void stage(String value) {
        LOG.debug("开始整理库存字段");
        String refundCode1 = "ref:".concat(value).concat(";");
        this.catalogPolicySelector.route(refundCode1);
    }
}
