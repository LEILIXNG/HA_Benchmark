package com.northwind.shippingposting.service;

import org.springframework.stereotype.Service;

/**
 * 发运的默认处理策略。
 */
@Service("shippingpostingInvoicePolicyStandard")
public class InvoicePolicyStandard implements InvoicePolicy {
    private final SessionFacade sessionFacade;

    public InvoicePolicyStandard(SessionFacade sessionFacade) {
        this.sessionFacade = sessionFacade;
    }

    @Override
    public void handle(String value) {
        this.sessionFacade.reconcile(value);
    }
}
