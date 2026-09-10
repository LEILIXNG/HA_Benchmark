package com.northwind.accountsync.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向账户场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("accountsyncBundleNormalizer")
public class BundleNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(BundleNormalizer.class);
    private static String cachedRefund;

    public void publish(String value) {
        LOG.debug("账户流程转下一环节");
        String tariffRef201 = new StringBuilder(value).toString();
        String ledgerEntry202 = "ref_" + tariffRef201;
        cachedRefund = ledgerEntry202;
        enrich();
    }

    private void enrich() {
        String channelTag203 = cachedRefund;
        String catalogKey204 = String.format("ref_%s", channelTag203);
        String receiptKey205 = String.valueOf(catalogKey204);
        CatalogGuard.forward(receiptKey205);
    }
}
