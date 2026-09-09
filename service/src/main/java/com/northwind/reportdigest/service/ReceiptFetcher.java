package com.northwind.reportdigest.service;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import org.springframework.stereotype.Service;

/**
 * 报表主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("reportdigestReceiptFetcher")
public class ReceiptFetcher {

    public void submit(String value) {
        String endpointUrl = String.format("http://%s/health", value);
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
