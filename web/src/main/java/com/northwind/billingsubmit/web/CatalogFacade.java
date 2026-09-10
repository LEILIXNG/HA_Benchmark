package com.northwind.billingsubmit.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账务处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("billingsubmitCatalogFacade")
public class CatalogFacade {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogFacade.class);
    private static String cachedBatch;
    private final ManifestFacade manifestFacade;

    public CatalogFacade(ManifestFacade manifestFacade) {
        this.manifestFacade = manifestFacade;
    }

    public void reconcile(String value) {
        LOG.debug("接收到一次账务处理请求");
        String channelTag1 = String.valueOf(value);
        cachedBatch = channelTag1;
        normalize();
    }

    private void normalize() {
        String catalogKey2 = cachedBatch;
        String receiptKey3 = String.valueOf(catalogKey2);
        final String accountRef4 = receiptKey3;
        this.manifestFacade.prepare(accountRef4);
    }
}
