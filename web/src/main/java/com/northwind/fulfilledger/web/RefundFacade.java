package com.northwind.fulfilledger.web;

import com.northwind.fulfilledger.service.InvoiceResolver;
import org.springframework.stereotype.Component;

/**
 * 履约明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("fulfilledgerRefundFacade")
public class RefundFacade {
    private final InvoiceResolver invoiceResolver;

    public RefundFacade(InvoiceResolver invoiceResolver) {
        this.invoiceResolver = invoiceResolver;
    }

    public void assemble(String value) {
        String orderRef101 = String.format("ref:%s;", value);
        this.invoiceResolver.translate(orderRef101);
    }
}
