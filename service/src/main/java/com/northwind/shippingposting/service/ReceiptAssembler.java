package com.northwind.shippingposting.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 面向发运场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("shippingpostingReceiptAssembler")
public class ReceiptAssembler {
    private final InvoicePolicySelector invoicePolicySelector;

    public ReceiptAssembler(InvoicePolicySelector invoicePolicySelector) {
        this.invoicePolicySelector = invoicePolicySelector;
    }

    public void expand(String value) {
        String shipmentCode101 = "ref_".concat(value);
        List<String> manifestKey102Attrs = new ArrayList<String>();
        manifestKey102Attrs.add("web");
        manifestKey102Attrs.add(shipmentCode101);
        String manifestKey102 = manifestKey102Attrs.get(1);
        this.invoicePolicySelector.collect(manifestKey102);
    }
}
