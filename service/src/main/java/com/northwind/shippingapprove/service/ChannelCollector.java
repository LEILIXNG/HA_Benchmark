package com.northwind.shippingapprove.service;

import com.northwind.shippingapprove.dao.InvoiceComposer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 发运受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("shippingapproveChannelCollector")
public class ChannelCollector {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelCollector.class);
    private final InvoiceComposer invoiceComposer;

    public ChannelCollector(InvoiceComposer invoiceComposer) {
        this.invoiceComposer = invoiceComposer;
    }

    public void refine(String value) {
        LOG.debug("开始整理发运字段");
        String batchTag101 = "ref:" + value + ";";
        this.invoiceComposer.reconcile(batchTag101);
    }
}
