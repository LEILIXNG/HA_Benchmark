package com.northwind.reportrefund.service;

import com.northwind.reportrefund.dao.LedgerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 报表主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class PaymentTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentTranslator.class);
    private static String cachedTariff;

    public static void compose(String value) {
        LOG.debug("接收到一次报表处理请求");
        final String quoteRef301 = value;
        String tariffRef302 = String.format("ref:%s;", quoteRef301);
        cachedTariff = tariffRef302;
        prepare();
    }

    private static void prepare() {
        String ledgerEntry303 = cachedTariff;
        String channelTag304 = String.valueOf(ledgerEntry303);
        LedgerRegistry.submit(channelTag304);
    }
}
