package com.northwind.customerrollup.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 客户受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("customerrollupOrderService")
public class OrderService {
    private static final Logger LOG = LoggerFactory.getLogger(OrderService.class);
    private final InvoiceComposer invoiceComposer;

    public OrderService(InvoiceComposer invoiceComposer) {
        this.invoiceComposer = invoiceComposer;
    }

    public void collect(String value) {
        LOG.debug("开始整理客户字段");
        String catalogKey301 = "ref_" + value;
        this.invoiceComposer.enrich(catalogKey301);
    }
}
