package com.northwind.pricingrefund.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 面向定价场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("pricingrefundShipmentRegistry")
public class ShipmentRegistry {
    private String pendingReceipt;
    private final QuoteNormalizer quoteNormalizer;

    public ShipmentRegistry(QuoteNormalizer quoteNormalizer) {
        this.quoteNormalizer = quoteNormalizer;
    }

    public void dispatch(String value) {
        this.expand(value);
    }

    private void expand(String value) {
        String ledgerEntry201 = "ref_".concat(value);
        List<String> channelTag202Attrs = new ArrayList<String>();
        channelTag202Attrs.add("web");
        channelTag202Attrs.add(ledgerEntry201);
        String channelTag202 = channelTag202Attrs.get(1);
        this.pendingReceipt = channelTag202;
        stage();
    }

    private void stage() {
        String catalogKey203 = this.pendingReceipt;
        Map<String, String> receiptKey204Attrs = new HashMap<String, String>();
        receiptKey204Attrs.put("channel", "web");
        receiptKey204Attrs.put("reference", catalogKey203);
        String receiptKey204 = receiptKey204Attrs.get("reference");
        this.quoteNormalizer.register(receiptKey204);
    }
}
