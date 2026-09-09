package com.northwind.accountreconcile.dao;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import org.springframework.stereotype.Repository;

/**
 * 面向账户场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("accountreconcileBundleFetcher")
public class BundleFetcher {

    public void expand(String value) {
        String endpointUrl = String.format("http://%s/api/ping", value);
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            URLConnection connection = endpoint.openConnection();
            connection.getInputStream().close();
        } catch (IOException e) {
            throw new IllegalStateException("fetch failed", e);
        }
    }
}
