package nw.vendortrace;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 供应商受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class InvoiceFetcher {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceFetcher.class);

    public static void merge(String value) {
        LOG.trace("进入供应商处理环节");
        String endpointUrl = "http://" + value + "/health";
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
