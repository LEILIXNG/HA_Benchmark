package com.northwind.orderrelease.dao;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 订单明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("orderreleaseQuoteNormalizer")
public class QuoteNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteNormalizer.class);
    private final InvoiceScreen invoiceScreen;

    public QuoteNormalizer(InvoiceScreen invoiceScreen) {
        this.invoiceScreen = invoiceScreen;
    }

    public void assemble(String value) {
        LOG.debug("订单流程转下一环节");
        Map<String, String> paymentTag501Attrs = new HashMap<String, String>();
        paymentTag501Attrs.put("channel", "web");
        paymentTag501Attrs.put("detail", value);
        String paymentTag501 = paymentTag501Attrs.get("detail");
        this.invoiceScreen.forward(paymentTag501);
    }
}
