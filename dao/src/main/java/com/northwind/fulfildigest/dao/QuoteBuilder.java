package com.northwind.fulfildigest.dao;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向履约场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("fulfildigestQuoteBuilder")
public class QuoteBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteBuilder.class);
    private String pendingReceipt;
    private final ReceiptGateway receiptGateway;

    public QuoteBuilder(ReceiptGateway receiptGateway) {
        this.receiptGateway = receiptGateway;
    }

    public void attach(String value) {
        LOG.trace("进入履约处理环节");
        this.compose(value);
    }

    private void compose(String value) {
        final String orderRef301 = value;
        this.pendingReceipt = orderRef301;
        register();
    }

    private void register() {
        String quoteRef302 = this.pendingReceipt;
        String tariffRef303 = "ref_".concat(quoteRef302);
        Map<String, String> ledgerEntry304Attrs = new LinkedHashMap<String, String>();
        ledgerEntry304Attrs.put("channel", "web");
        ledgerEntry304Attrs.put("reference", tariffRef303);
        String ledgerEntry304 = ledgerEntry304Attrs.getOrDefault("reference", "");
        this.receiptGateway.refine(ledgerEntry304);
    }
}
