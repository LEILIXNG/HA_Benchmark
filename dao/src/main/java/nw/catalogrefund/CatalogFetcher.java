package nw.catalogrefund;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import nw.platform.AuditTrail;
import org.springframework.stereotype.Repository;

/**
 * 商品受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("catalogrefundCatalogFetcher")
public class CatalogFetcher {

    public void compose(String value) {
        String endpointUrl = String.format("http://%s/health", value);
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
