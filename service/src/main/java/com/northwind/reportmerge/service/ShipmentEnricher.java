package com.northwind.reportmerge.service;

import com.northwind.reportmerge.dao.ManifestResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向报表场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ShipmentEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentEnricher.class);
    private static String cachedContract;

    public static void resolve(String value) {
        LOG.debug("报表流程转下一环节");
        final String quoteRef101 = value;
        cachedContract = quoteRef101;
        refine();
    }

    private static void refine() {
        String tariffRef102 = cachedContract;
        String ledgerEntry103 = String.format("ref_%s", tariffRef102);
        cachedContract = ledgerEntry103;
        forward();
    }

    private static void forward() {
        String channelTag104 = cachedContract;
        String catalogKey105 = "ref_" + channelTag104;
        ManifestResolver.normalize(catalogKey105);
    }
}
