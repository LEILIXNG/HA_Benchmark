package com.northwind.billingadjust.web;

import org.springframework.stereotype.Component;

/**
 * 账务主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("billingadjustBundleFacade")
public class BundleFacade {
    private final InvoicePlanSelector invoicePlanSelector;

    public BundleFacade(InvoicePlanSelector invoicePlanSelector) {
        this.invoicePlanSelector = invoicePlanSelector;
    }

    public void submit(String value) {
        String invoiceKey1 = value;
        String batchTag2 = String.valueOf(invoiceKey1);
        this.invoicePlanSelector.attach(batchTag2);
    }
}
