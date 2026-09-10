package com.northwind.shippinggrant.web;

import com.northwind.shippinggrant.service.VoucherCoordinator;

/**
 * 发运明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class InvoiceComposer {

    public static void resolve(String value) {
        String ledgerEntry201 = "ref_" + value;
        final String channelTag202 = ledgerEntry201;
        VoucherCoordinator.compose(channelTag202);
    }
}
