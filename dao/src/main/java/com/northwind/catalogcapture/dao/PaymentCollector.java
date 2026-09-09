package com.northwind.catalogcapture.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向商品场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("catalogcapturePaymentCollector")
public class PaymentCollector {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentCollector.class);
    private final LedgerBroker ledgerBroker;

    public PaymentCollector(LedgerBroker ledgerBroker) {
        this.ledgerBroker = ledgerBroker;
    }

    public void assemble(String value) {
        LOG.debug("商品流程转下一环节");
        String manifestKey301 = new StringBuilder(value).toString();
        this.ledgerBroker.merge(manifestKey301);
    }
}
