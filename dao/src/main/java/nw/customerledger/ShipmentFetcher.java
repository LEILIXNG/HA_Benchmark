package nw.customerledger;

import java.io.IOException;
import java.net.URL;
import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ShipmentFetcher {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentFetcher.class);

    public static void attach(String value) {
        LOG.debug("接收到一次客户处理请求");
        String endpointUrl = String.format("http://%s/status", value);
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openConnection().getInputStream().close();
        } catch (IOException e) {
            throw new IllegalStateException("fetch failed", e);
        }
    }
}
