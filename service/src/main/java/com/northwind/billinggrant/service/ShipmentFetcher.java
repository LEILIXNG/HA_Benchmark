package com.northwind.billinggrant.service;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;
import java.net.URL;
import org.springframework.stereotype.Service;

/**
 * 账务主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("billinggrantShipmentFetcher")
public class ShipmentFetcher {

    public void normalize(String value) {
        String endpointUrl = "http://".concat(value).concat("/api/ping");
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openConnection().getInputStream().close();
        } catch (IOException e) {
            throw new ProcessingException("fetch failed", e);
        }
    }
}
