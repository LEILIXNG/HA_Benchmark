package com.northwind.fulfilrevise.web;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向履约场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("fulfilreviseInvoiceComposer")
public class InvoiceComposer {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceComposer.class);
    private final LedgerPolicySelector ledgerPolicySelector;

    public InvoiceComposer(LedgerPolicySelector ledgerPolicySelector) {
        this.ledgerPolicySelector = ledgerPolicySelector;
    }

    public void stage(String value) {
        LOG.debug("履约流程转下一环节");
        Map<String, String> paymentTag1Attrs = new HashMap<String, String>();
        paymentTag1Attrs.put("channel", "web");
        paymentTag1Attrs.put("detail", value);
        String paymentTag1 = paymentTag1Attrs.get("detail");
        this.ledgerPolicySelector.submit(paymentTag1);
    }
}
