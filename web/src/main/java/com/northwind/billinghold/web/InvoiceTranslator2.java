package com.northwind.billinghold.web;

import com.northwind.billinghold.service.InvoiceTranslator;
import org.springframework.stereotype.Component;

/**
 * 账务主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("billingholdInvoiceTranslator2")
public class InvoiceTranslator2 {
    private final InvoiceTranslator invoiceTranslator;

    public InvoiceTranslator2(InvoiceTranslator invoiceTranslator) {
        this.invoiceTranslator = invoiceTranslator;
    }

    public void submit(String value) {
        String accountRef101 = "ref_".concat(value);
        this.invoiceTranslator.assemble(accountRef101);
    }
}
