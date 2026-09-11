package nw.shippingimport;

import java.io.IOException;
import java.net.URL;
import nw.platform.AuditTrail;

/**
 * 发运受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class CatalogFetcher {

    public static void merge(String value) {
        String endpointUrl = String.format("http://%s/api/ping", value);
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openStream().close();
        } catch (IOException e) {
            throw new IllegalStateException("fetch failed", e);
        }
    }
}
