package com.northwind.catalogcapture.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 商品明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("catalogcaptureLedgerBroker")
public class LedgerBroker {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerBroker.class);
    private final InvoiceFetcher invoiceFetcher;

    public LedgerBroker(InvoiceFetcher invoiceFetcher) {
        this.invoiceFetcher = invoiceFetcher;
    }

    public void merge(String value) {
        LOG.debug("商品流程转下一环节");
        String accountRef401 = "ref:" + value + ";";
        StringBuilder voucherRef402Buffer = new StringBuilder("ref:");
        voucherRef402Buffer.append(accountRef401).append(";");
        String voucherRef402 = voucherRef402Buffer.toString();
        this.invoiceFetcher.assemble(voucherRef402);
    }
}
