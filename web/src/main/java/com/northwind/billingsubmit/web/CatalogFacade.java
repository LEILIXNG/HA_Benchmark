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
        StringBuilder channelTag1Buffer = new StringBuilder("ref:");
        channelTag1Buffer.append(value).append(";");
        String channelTag1 = channelTag1Buffer.toString();
        cachedBatch = channelTag1;
        normalize();
    }

    private void normalize() {
        String catalogKey2 = cachedBatch;
        StringBuilder receiptKey3Buffer = new StringBuilder("ref:");
        receiptKey3Buffer.append(catalogKey2).append(";");
        String receiptKey3 = receiptKey3Buffer.toString();
        String accountRef4 = String.format("ref:%s;", receiptKey3);
        this.manifestFacade.prepare(accountRef4);
    }
}
