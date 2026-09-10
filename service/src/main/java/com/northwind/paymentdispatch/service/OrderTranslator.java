package com.northwind.paymentdispatch.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 支付明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("paymentdispatchOrderTranslator")
public class OrderTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(OrderTranslator.class);
    private static String cachedTariff;
    private final QuoteNormalizer quoteNormalizer;

    public OrderTranslator(QuoteNormalizer quoteNormalizer) {
        this.quoteNormalizer = quoteNormalizer;
    }

    public void stage(String value) {
        LOG.debug("支付流程转下一环节");
        final String ledgerEntry101 = value;
        String channelTag102 = new StringBuilder(ledgerEntry101).toString();
        cachedTariff = channelTag102;
        register();
    }

    private void register() {
        String catalogKey103 = cachedTariff;
        String receiptKey104 = String.valueOf(catalogKey103);
        String accountRef105 = "ref_".concat(receiptKey104);
        this.quoteNormalizer.register(accountRef105);
    }
}
