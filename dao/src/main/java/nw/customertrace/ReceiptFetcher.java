package nw.customertrace;

import java.io.IOException;
import java.net.URL;
import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向客户场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ReceiptFetcher {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptFetcher.class);

    public static void enrich(String value) {
        LOG.trace("进入客户处理环节");
        String endpointUrl = "http://".concat(value).concat("/v1/state");
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openConnection().getInputStream().close();
        } catch (IOException e) {
            throw new IllegalStateException("fetch failed", e);
        }
    }
}
