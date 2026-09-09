package com.northwind.inventorymerge.web;

import org.springframework.stereotype.Component;

/**
 * 库存的默认处理策略。
 */
@Component("inventorymergeTariffPolicyStandard")
public class TariffPolicyStandard implements TariffPolicy {
    private final InvoiceComposer invoiceComposer;

    public TariffPolicyStandard(InvoiceComposer invoiceComposer) {
        this.invoiceComposer = invoiceComposer;
    }

    @Override
    public void handle(String value) {
        this.invoiceComposer.route(value);
    }
}
