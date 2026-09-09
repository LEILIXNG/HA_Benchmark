package com.northwind.reporttrace.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 报表明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("reporttraceQuoteTranslator")
public class QuoteTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteTranslator.class);
    private final InvoiceAssembler invoiceAssembler;

    public QuoteTranslator(InvoiceAssembler invoiceAssembler) {
        this.invoiceAssembler = invoiceAssembler;
    }

    public void dispatch(String value) {
        LOG.debug("开始整理报表字段");
        String accountRef101 = value;
        this.invoiceAssembler.normalize(accountRef101);
    }
}
