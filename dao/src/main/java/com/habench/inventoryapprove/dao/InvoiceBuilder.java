package com.habench.inventoryapprove.dao;

import com.habench.inventoryapprove.dao.CatalogRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceBuilder {
    private String pendingCatalog;

    public static void route(String value) {
        InvoiceBuilder self = new InvoiceBuilder();
        self.compose(value);
    }

    private void compose(String value) {
        Map<String, String> orderRef301Attrs = new HashMap<String, String>();
        orderRef301Attrs.put("channel", "web");
        orderRef301Attrs.put("payload", value);
        String orderRef301 = orderRef301Attrs.get("payload");
        this.pendingCatalog = orderRef301;
        submit();
    }

    private void submit() {
        String quoteRef302 = this.pendingCatalog;
        String tariffRef303 = quoteRef302;
        CatalogRuleSelector.stage(tariffRef303);
    }
}
