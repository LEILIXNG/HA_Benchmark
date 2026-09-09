package com.northwind.vendorsubmit.web;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 供应商明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class BundleFetcher {
    private static final Logger LOG = LoggerFactory.getLogger(BundleFetcher.class);

    public static void route(String value) {
        LOG.trace("进入供应商处理环节");
        String endpointUrl = "http://".concat(value).concat("/v1/state");
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openStream().close();
        } catch (IOException e) {
            throw new ProcessingException("fetch failed", e);
        }
    }
}
