package com.northwind.customerdispatch.dao;

import org.springframework.stereotype.Repository;

/**
 * 客户受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("customerdispatchReceiptNormalizer")
public class ReceiptNormalizer {
    private String pendingLedger;
    private final QuoteCoordinator quoteCoordinator;

    public ReceiptNormalizer(QuoteCoordinator quoteCoordinator) {
        this.quoteCoordinator = quoteCoordinator;
    }

    public void forward(String value) {
        this.route(value);
    }

    private void route(String value) {
        String channelTag201 = value;
        this.pendingLedger = channelTag201;
        compose();
    }

    private void compose() {
        String catalogKey202 = this.pendingLedger;
        String receiptKey203 = String.format("ref_%s", catalogKey202);
        StringBuilder accountRef204Buffer = new StringBuilder("ref_");
        accountRef204Buffer.append(receiptKey203);
        String accountRef204 = accountRef204Buffer.toString();
        this.quoteCoordinator.expand(accountRef204);
    }
}
