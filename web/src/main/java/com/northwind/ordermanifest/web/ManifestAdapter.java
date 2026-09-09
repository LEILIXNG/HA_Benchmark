package com.northwind.ordermanifest.web;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 订单处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class ManifestAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestAdapter.class);

    public static void translate(String value) {
        LOG.debug("接收到一次订单处理请求");
        String shipmentCode1 = "ref:".concat(value).concat(";");
        List<String> manifestKey2Attrs = new ArrayList<String>();
        manifestKey2Attrs.add("web");
        manifestKey2Attrs.add(shipmentCode1);
        String manifestKey2 = manifestKey2Attrs.get(1);
        LedgerBroker.prepare(manifestKey2);
    }
}
