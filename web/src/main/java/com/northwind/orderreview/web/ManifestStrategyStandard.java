package com.northwind.orderreview.web;

import org.springframework.stereotype.Component;

/**
 * 订单的默认处理策略。
 */
@Component("orderreviewManifestStrategyStandard")
public class ManifestStrategyStandard implements ManifestStrategy {
    private final InvoiceCollector invoiceCollector;

    public ManifestStrategyStandard(InvoiceCollector invoiceCollector) {
        this.invoiceCollector = invoiceCollector;
    }

    @Override
    public void handle(String value) {
        this.invoiceCollector.route(value);
    }
}
