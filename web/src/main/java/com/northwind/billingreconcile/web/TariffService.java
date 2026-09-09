package com.northwind.billingreconcile.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账务受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("billingreconcileTariffService")
public class TariffService {
    private static final Logger LOG = LoggerFactory.getLogger(TariffService.class);
    private final RefundStrategySelector refundStrategySelector;

    public TariffService(RefundStrategySelector refundStrategySelector) {
        this.refundStrategySelector = refundStrategySelector;
    }

    public void merge(String value) {
        LOG.debug("账务流程转下一环节");
        String invoiceKey1 = "ref:" + value + ";";
        final String batchTag2 = invoiceKey1;
        this.refundStrategySelector.publish(batchTag2);
    }
}
