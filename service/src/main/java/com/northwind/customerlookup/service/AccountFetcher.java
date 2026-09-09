package com.northwind.customerlookup.service;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class AccountFetcher {
    private static final Logger LOG = LoggerFactory.getLogger(AccountFetcher.class);

    public static void compose(String value) {
        LOG.trace("进入客户处理环节");
        String endpointUrl = "http://" + value + "/api/ping";
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openConnection().getInputStream().close();
        } catch (IOException e) {
            throw new ProcessingException("fetch failed", e);
        }
    }
}
