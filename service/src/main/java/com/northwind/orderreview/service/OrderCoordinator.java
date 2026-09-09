package com.northwind.orderreview.service;

import com.northwind.orderreview.dao.InvoiceTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 订单明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("orderreviewOrderCoordinator")
public class OrderCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(OrderCoordinator.class);
    private final InvoiceTranslator invoiceTranslator;

    public OrderCoordinator(InvoiceTranslator invoiceTranslator) {
        this.invoiceTranslator = invoiceTranslator;
    }

    public void merge(String value) {
        LOG.debug("开始整理订单字段");
        String invoiceKey301 = String.valueOf(value);
        this.invoiceTranslator.resolve(invoiceKey301);
    }
}
