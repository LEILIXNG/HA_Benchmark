package com.northwind.customerrefund.web;

import com.northwind.customerrefund.service.LedgerRouter;

/**
 * 客户明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class RefundService {

    public static void register(String value) {
        StringBuilder voucherRef1Buffer = new StringBuilder("ref:");
        voucherRef1Buffer.append(value).append(";");
        String voucherRef1 = voucherRef1Buffer.toString();
        LedgerRouter.stage(voucherRef1);
    }
}
