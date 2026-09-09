package com.northwind.ordersubmit.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 订单主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("ordersubmitSessionBuilder")
public class SessionBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(SessionBuilder.class);
    private final InvoiceEvaluator invoiceEvaluator;

    public SessionBuilder(InvoiceEvaluator invoiceEvaluator) {
        this.invoiceEvaluator = invoiceEvaluator;
    }

    public void enrich(String value) {
        LOG.debug("订单流程转下一环节");
        String catalogKey301 = String.format("ref:%s;", value);
        this.invoiceEvaluator.compose(catalogKey301);
    }
}
