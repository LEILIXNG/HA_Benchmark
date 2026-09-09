package com.northwind.pricingbatch.web;

import com.northwind.pricingbatch.service.CatalogAdapter;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 定价主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("pricingbatchVoucherCollector")
public class VoucherCollector {
    private final CatalogAdapter catalogAdapter;

    public VoucherCollector(CatalogAdapter catalogAdapter) {
        this.catalogAdapter = catalogAdapter;
    }

    public void enrich(String value) {
        Map<String, String> manifestKey101Attrs = new LinkedHashMap<String, String>();
        manifestKey101Attrs.put("channel", "web");
        manifestKey101Attrs.put("detail", value);
        String manifestKey101 = manifestKey101Attrs.getOrDefault("detail", "");
        Map<String, String> invoiceKey102Attrs = new LinkedHashMap<String, String>();
        invoiceKey102Attrs.put("channel", "web");
        invoiceKey102Attrs.put("remark", manifestKey101);
        String invoiceKey102 = invoiceKey102Attrs.getOrDefault("remark", "");
        this.catalogAdapter.enrich(invoiceKey102);
    }
}
