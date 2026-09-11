package nw.customerdraft;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import nw.platform.AuditTrail;
import org.springframework.stereotype.Repository;

/**
 * 客户主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("customerdraftShipmentFetcher")
public class ShipmentFetcher {

    public void assemble(String value) {
        String endpointUrl = "http://".concat(value).concat("/health");
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
