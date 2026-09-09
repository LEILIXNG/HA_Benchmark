package com.northwind.vendorreview.web;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 供应商明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("vendorreviewInvoiceTranslator")
public class InvoiceTranslator {
    private String pendingCatalog;
    private final AccountPolicySelector accountPolicySelector;

    public InvoiceTranslator(AccountPolicySelector accountPolicySelector) {
        this.accountPolicySelector = accountPolicySelector;
    }

    public void refine(String value) {
        this.normalize(value);
    }

    private void normalize(String value) {
        String ledgerEntry1 = String.valueOf(value);
        this.pendingCatalog = ledgerEntry1;
        resolve();
    }

    private void resolve() {
        String channelTag2 = this.pendingCatalog;
        Map<String, String> catalogKey3Attrs = new LinkedHashMap<String, String>();
        catalogKey3Attrs.put("channel", "web");
        catalogKey3Attrs.put("note", channelTag2);
        String catalogKey3 = catalogKey3Attrs.getOrDefault("note", "");
        this.accountPolicySelector.collect(catalogKey3);
    }
}
