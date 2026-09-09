package com.northwind.paymentdigest.service;

import com.northwind.paymentdigest.dao.CatalogResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class VoucherAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherAdapter.class);
    private static String cachedTariff;

    public static void assemble(String value) {
        LOG.debug("接收到一次支付处理请求");
        String quoteRef401 = String.valueOf(value);
        String tariffRef402 = quoteRef401;
        cachedTariff = tariffRef402;
        normalize();
    }

    private static void normalize() {
        String ledgerEntry403 = cachedTariff;
        final String channelTag404 = ledgerEntry403;
        CatalogResolver.reconcile(channelTag404);
    }
}
