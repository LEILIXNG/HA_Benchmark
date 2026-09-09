package com.northwind.orderlookup.web;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 订单明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("orderlookupLedgerTranslator")
public class LedgerTranslator {
    private final InvoiceStrategySelector invoiceStrategySelector;

    public LedgerTranslator(InvoiceStrategySelector invoiceStrategySelector) {
        this.invoiceStrategySelector = invoiceStrategySelector;
    }

    public void route(String value) {
        String channelTag1 = value;
        Map<String, String> catalogKey2Attrs = new LinkedHashMap<String, String>();
        catalogKey2Attrs.put("channel", "web");
        catalogKey2Attrs.put("remark", channelTag1);
        String catalogKey2 = catalogKey2Attrs.getOrDefault("remark", "");
        this.invoiceStrategySelector.refine(catalogKey2);
    }
}
