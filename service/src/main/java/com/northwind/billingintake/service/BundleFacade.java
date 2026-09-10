package com.northwind.billingintake.service;

import com.northwind.billingintake.dao.BatchBuilder;

/**
 * 账务处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class BundleFacade {
    private String pendingInvoice;

    public static void submit(String value) {
        BundleFacade self = new BundleFacade();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String orderRef101 = String.format("ref_%s", value);
        String quoteRef102 = "ref_".concat(orderRef101);
        this.pendingInvoice = quoteRef102;
        reconcile();
    }

    private void reconcile() {
        String tariffRef103 = this.pendingInvoice;
        String ledgerEntry104 = tariffRef103;
        BatchBuilder.expand(ledgerEntry104);
    }
}
