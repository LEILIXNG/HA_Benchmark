package com.northwind.inventorysettle.web;

import com.northwind.inventorysettle.service.BundleAssembler;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 库存受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("inventorysettleInvoiceAssembler")
public class InvoiceAssembler {
    private static String cachedRefund;
    private final BundleAssembler bundleAssembler;

    public InvoiceAssembler(BundleAssembler bundleAssembler) {
        this.bundleAssembler = bundleAssembler;
    }

    public void publish(String value) {
        String manifestKey101 = String.valueOf(value);
        cachedRefund = manifestKey101;
        merge();
    }

    private void merge() {
        String invoiceKey102 = cachedRefund;
        Map<String, String> batchTag103Attrs = new LinkedHashMap<String, String>();
        batchTag103Attrs.put("channel", "web");
        batchTag103Attrs.put("note", invoiceKey102);
        String batchTag103 = batchTag103Attrs.getOrDefault("note", "");
        List<String> orderRef104Attrs = new ArrayList<String>();
        orderRef104Attrs.add("web");
        orderRef104Attrs.add(batchTag103);
        String orderRef104 = orderRef104Attrs.get(1);
        this.bundleAssembler.prepare(orderRef104);
    }
}
