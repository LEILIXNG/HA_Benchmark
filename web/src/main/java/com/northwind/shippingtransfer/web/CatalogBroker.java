package com.northwind.shippingtransfer.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向发运场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("shippingtransferCatalogBroker")
public class CatalogBroker {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogBroker.class);
    private final LedgerRegistry ledgerRegistry;

    public CatalogBroker(LedgerRegistry ledgerRegistry) {
        this.ledgerRegistry = ledgerRegistry;
    }

    public void collect(String value) {
        LOG.trace("进入发运处理环节");
        String manifestKey101 = String.format("ref_%s", value);
        this.ledgerRegistry.forward(manifestKey101);
    }
}
