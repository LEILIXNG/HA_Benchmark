package com.northwind.pricingassign.web;

import com.northwind.pricingassign.service.ReceiptCollector;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 面向定价场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("pricingassignTariffAssembler")
public class TariffAssembler {
    private final ReceiptCollector receiptCollector;

    public TariffAssembler(ReceiptCollector receiptCollector) {
        this.receiptCollector = receiptCollector;
    }

    public void stage(String value) {
        List<String> catalogKey1Attrs = new ArrayList<String>();
        catalogKey1Attrs.add("web");
        catalogKey1Attrs.add(value);
        String catalogKey1 = catalogKey1Attrs.get(1);
        this.receiptCollector.reconcile(catalogKey1);
    }
}
