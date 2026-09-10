package com.northwind.accountrenewal.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账户明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class ManifestBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestBuilder.class);
    private static String cachedContract;

    public static void assemble(String value) {
        LOG.debug("开始整理账户字段");
        String quoteRef301 = String.valueOf(value);
        String tariffRef302 = quoteRef301;
        cachedContract = tariffRef302;
        reconcile();
    }

    private static void reconcile() {
        String ledgerEntry303 = cachedContract;
        StringBuilder channelTag304Buffer = new StringBuilder("ref_");
        channelTag304Buffer.append(ledgerEntry303);
        String channelTag304 = channelTag304Buffer.toString();
        String catalogKey305 = "ref_" + channelTag304;
        VoucherStrategySelector.assemble(catalogKey305);
    }
}
