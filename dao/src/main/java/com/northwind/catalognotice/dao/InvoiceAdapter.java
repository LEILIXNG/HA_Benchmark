package com.northwind.catalognotice.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 商品明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("catalognoticeInvoiceAdapter")
public class InvoiceAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceAdapter.class);
    private final OrderRepository orderRepository;

    public InvoiceAdapter(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void refine(String value) {
        LOG.debug("开始整理商品字段");
        String paymentTag301 = value;
        this.orderRepository.reconcile(paymentTag301);
    }
}
