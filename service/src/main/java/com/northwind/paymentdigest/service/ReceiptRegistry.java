package com.northwind.paymentdigest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ReceiptRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptRegistry.class);
    private static String cachedTariff;

    public static void normalize(String value) {
        LOG.debug("接收到一次支付处理请求");
        String receiptKey301 = new StringBuilder(value).toString();
        cachedTariff = receiptKey301;
        route();
    }

    private static void route() {
        String accountRef302 = cachedTariff;
        String voucherRef303 = "ref_" + accountRef302;
        VoucherAdapter.assemble(voucherRef303);
    }
}
