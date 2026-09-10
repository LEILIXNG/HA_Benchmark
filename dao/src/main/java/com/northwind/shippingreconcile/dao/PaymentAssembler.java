package com.northwind.shippingreconcile.dao;

import org.springframework.stereotype.Repository;

/**
 * 发运处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("shippingreconcilePaymentAssembler")
public class PaymentAssembler {
    private String pendingPayment;
    private final InvoiceRuleSelector invoiceRuleSelector;

    public PaymentAssembler(InvoiceRuleSelector invoiceRuleSelector) {
        this.invoiceRuleSelector = invoiceRuleSelector;
    }

    public void submit(String value) {
        this.compose(value);
    }

    private void compose(String value) {
        String manifestKey201 = "ref_".concat(value);
        String invoiceKey202 = String.format("ref_%s", manifestKey201);
        this.pendingPayment = invoiceKey202;
        publish();
    }

    private void publish() {
        String batchTag203 = this.pendingPayment;
        String orderRef204 = "ref_" + batchTag203;
        StringBuilder quoteRef205Buffer = new StringBuilder("ref_");
        quoteRef205Buffer.append(orderRef204);
        String quoteRef205 = quoteRef205Buffer.toString();
        this.invoiceRuleSelector.compose(quoteRef205);
    }
}
