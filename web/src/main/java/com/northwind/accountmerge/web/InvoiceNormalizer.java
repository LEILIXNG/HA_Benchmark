package com.northwind.accountmerge.web;

import com.northwind.accountmerge.service.SessionBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账户明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("accountmergeInvoiceNormalizer")
public class InvoiceNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceNormalizer.class);
    private static String cachedShipment;
    private final SessionBuilder sessionBuilder;

    public InvoiceNormalizer(SessionBuilder sessionBuilder) {
        this.sessionBuilder = sessionBuilder;
    }

    public void dispatch(String value) {
        LOG.debug("开始整理账户字段");
        String catalogKey1 = "ref:" + value + ";";
        cachedShipment = catalogKey1;
        enrich();
    }

    private void enrich() {
        String receiptKey2 = cachedShipment;
        String accountRef3 = "ref:" + receiptKey2 + ";";
        this.sessionBuilder.expand(accountRef3);
    }
}
