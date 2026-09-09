package com.northwind.reportrenewal.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 报表受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("reportrenewalVoucherFetcher")
public class VoucherFetcher {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherFetcher.class);

    public void publish(String value) {
        LOG.debug("接收到一次报表处理请求");
        String endpointUrl = "http://".concat(value).concat("/health");
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openStream().close();
        } catch (IOException e) {
            throw new ProcessingException("fetch failed", e);
        }
    }
}
