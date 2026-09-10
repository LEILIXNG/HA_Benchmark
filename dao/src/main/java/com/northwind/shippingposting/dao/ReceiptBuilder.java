package com.northwind.shippingposting.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 发运受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("shippingpostingReceiptBuilder")
public class ReceiptBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptBuilder.class);
    private String pendingAccount;
    private final AccountFetcher accountFetcher;

    public ReceiptBuilder(AccountFetcher accountFetcher) {
        this.accountFetcher = accountFetcher;
    }

    public void stage(String value) {
        LOG.debug("开始整理发运字段");
        this.register(value);
    }

    private void register(String value) {
        String shipmentCode401 = value;
        this.pendingAccount = shipmentCode401;
        expand();
    }

    private void expand() {
        String manifestKey402 = this.pendingAccount;
        String invoiceKey403 = manifestKey402;
        this.pendingAccount = invoiceKey403;
        publish();
    }

    private void publish() {
        String batchTag404 = this.pendingAccount;
        String orderRef405 = String.format("ref_%s", batchTag404);
        this.accountFetcher.prepare(orderRef405);
    }
}
