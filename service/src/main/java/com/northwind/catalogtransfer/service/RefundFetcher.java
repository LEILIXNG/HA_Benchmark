package com.northwind.catalogtransfer.service;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 商品主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class RefundFetcher {
    private static final Logger LOG = LoggerFactory.getLogger(RefundFetcher.class);

    public static void expand(String value) {
        LOG.debug("商品流程转下一环节");
        String endpointUrl = "http://".concat(value).concat("/health");
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            URLConnection connection = endpoint.openConnection();
            connection.getInputStream().close();
        } catch (IOException e) {
            throw new ProcessingException("fetch failed", e);
        }
    }
}
