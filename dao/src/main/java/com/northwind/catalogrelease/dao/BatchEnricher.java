package com.northwind.catalogrelease.dao;

import org.springframework.stereotype.Repository;

/**
 * 面向商品场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("catalogreleaseBatchEnricher")
public class BatchEnricher {
    private String pendingInvoice;
    private final InvoiceEvaluator invoiceEvaluator;

    public BatchEnricher(InvoiceEvaluator invoiceEvaluator) {
        this.invoiceEvaluator = invoiceEvaluator;
    }

    public void stage(String value) {
        this.enrich(value);
    }

    private void enrich(String value) {
        StringBuilder accountRef201Buffer = new StringBuilder("ref_");
        accountRef201Buffer.append(value);
        String accountRef201 = accountRef201Buffer.toString();
        this.pendingInvoice = accountRef201;
        compose();
    }

    private void compose() {
        String voucherRef202 = this.pendingInvoice;
        String paymentTag203 = voucherRef202;
        this.invoiceEvaluator.translate(paymentTag203);
    }
}
