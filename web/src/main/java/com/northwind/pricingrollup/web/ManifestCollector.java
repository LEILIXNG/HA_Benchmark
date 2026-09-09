package com.northwind.pricingrollup.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向定价场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("pricingrollupManifestCollector")
public class ManifestCollector {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestCollector.class);
    private final InvoiceStrategySelector invoiceStrategySelector;

    public ManifestCollector(InvoiceStrategySelector invoiceStrategySelector) {
        this.invoiceStrategySelector = invoiceStrategySelector;
    }

    public void publish(String value) {
        LOG.trace("进入定价处理环节");
        String paymentTag101 = "ref:".concat(value).concat(";");
        this.invoiceStrategySelector.publish(paymentTag101);
    }
}
