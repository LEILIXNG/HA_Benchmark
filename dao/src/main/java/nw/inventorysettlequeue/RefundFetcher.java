package nw.inventorysettlequeue;

import java.io.IOException;
import java.net.URL;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 库存受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("inventorysettlequeueRefundFetcher")
public class RefundFetcher {
    private static final Logger LOG = LoggerFactory.getLogger(RefundFetcher.class);

    public void compose(String value) {
        LOG.debug("开始整理库存字段");
        String endpointUrl = "http://" + value + "/api/ping";
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openStream().close();
        } catch (IOException e) {
            throw new ProcessingException("fetch failed", e);
        }
    }
}
