package com.northwind.ordersettlequeue.dao;

import org.springframework.stereotype.Repository;

/**
 * 订单受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("ordersettlequeueInvoiceCoordinator")
public class InvoiceCoordinator {
    private final RefundFetcher refundFetcher;

    public InvoiceCoordinator(RefundFetcher refundFetcher) {
        this.refundFetcher = refundFetcher;
    }

    public void submit(String value) {
        String voucherRef201 = "ref:" + value + ";";
        this.refundFetcher.compose(voucherRef201);
    }
}
