package com.northwind.customerdigest.web;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 客户主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("customerdigestBatchResolver")
public class BatchResolver {
    private static String cachedPayment;
    private final CatalogPolicySelector catalogPolicySelector;

    public BatchResolver(CatalogPolicySelector catalogPolicySelector) {
        this.catalogPolicySelector = catalogPolicySelector;
    }

    public void normalize(String value) {
        Map<String, String> ledgerEntry1Attrs = new LinkedHashMap<String, String>();
        ledgerEntry1Attrs.put("channel", "web");
        ledgerEntry1Attrs.put("detail", value);
        String ledgerEntry1 = ledgerEntry1Attrs.getOrDefault("detail", "");
        cachedPayment = ledgerEntry1;
        assemble();
    }

    private void assemble() {
        String channelTag2 = cachedPayment;
        String catalogKey3 = String.valueOf(channelTag2);
        this.catalogPolicySelector.stage(catalogKey3);
    }
}
