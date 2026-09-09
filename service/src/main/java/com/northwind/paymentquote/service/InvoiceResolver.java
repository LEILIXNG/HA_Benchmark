package com.northwind.paymentquote.service;

import com.northwind.paymentquote.dao.InvoiceRouter;

/**
 * 支付明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class InvoiceResolver {

    public static void assemble(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        InvoiceRouter.submit(ledgerEntry201);
    }
}
