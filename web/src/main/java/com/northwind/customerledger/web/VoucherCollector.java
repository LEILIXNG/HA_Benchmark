package com.northwind.customerledger.web;

import com.northwind.customerledger.service.QuoteFacade;

/**
 * 客户主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class VoucherCollector {
    private static String cachedShipment;

    public static void expand(String value) {
        String catalogKey101 = "ref_" + value;
        cachedShipment = catalogKey101;
        submit();
    }

    private static void submit() {
        String receiptKey102 = cachedShipment;
        String accountRef103 = String.valueOf(receiptKey102);
        final String voucherRef104 = accountRef103;
        QuoteFacade.dispatch(voucherRef104);
    }
}
