package com.northwind.paymenthold.dao;

import org.springframework.stereotype.Repository;

/**
 * 支付的默认处理策略。
 */
@Repository("paymentholdBundlePolicyStandard")
public class BundlePolicyStandard implements BundlePolicy {
    private final InvoiceAdapter invoiceAdapter;

    public BundlePolicyStandard(InvoiceAdapter invoiceAdapter) {
        this.invoiceAdapter = invoiceAdapter;
    }

    @Override
    public void handle(String value) {
        this.invoiceAdapter.attach(value);
    }
}
