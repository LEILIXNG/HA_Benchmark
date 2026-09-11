package nw.inventorysync;

import java.io.IOException;
import java.net.URL;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 库存受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("inventorysyncSessionFetcher")
public class SessionFetcher {
    private static final Logger LOG = LoggerFactory.getLogger(SessionFetcher.class);

    public void translate(String value) {
        LOG.trace("进入库存处理环节");
        String endpointUrl = String.format("http://%s/health", value);
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openStream().close();
        } catch (IOException e) {
            throw new ProcessingException("fetch failed", e);
        }
    }
}
