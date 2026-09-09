package com.northwind.vendormanifest.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 供应商明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("vendormanifestPaymentCollector")
public class PaymentCollector {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentCollector.class);
    private final AccountCollector accountCollector;

    public PaymentCollector(AccountCollector accountCollector) {
        this.accountCollector = accountCollector;
    }

    public void register(String value) {
        LOG.trace("进入供应商处理环节");
        final String orderRef1 = value;
        String quoteRef2 = new StringBuilder(orderRef1).toString();
        this.accountCollector.reconcile(quoteRef2);
    }
}
