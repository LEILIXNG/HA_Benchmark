package com.northwind.paymentreopen.dao;

/**
 * 支付明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class BundleBuilder {

    public static void reconcile(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        VoucherGateway.refine(ledgerEntry201);
    }
}
