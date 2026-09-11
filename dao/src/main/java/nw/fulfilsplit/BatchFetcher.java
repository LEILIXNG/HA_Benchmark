package nw.fulfilsplit;

import java.io.IOException;
import java.net.URL;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向履约场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class BatchFetcher {
    private static final Logger LOG = LoggerFactory.getLogger(BatchFetcher.class);

    public static void prepare(String value) {
        LOG.debug("履约流程转下一环节");
        String endpointUrl = "http://" + value + "/status";
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openStream().close();
        } catch (IOException e) {
            throw new ProcessingException("fetch failed", e);
        }
    }
}
