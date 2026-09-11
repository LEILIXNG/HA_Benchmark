package nw.reportissue;

import java.io.IOException;
import java.net.URL;
import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向报表场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ContractFetcher {
    private static final Logger LOG = LoggerFactory.getLogger(ContractFetcher.class);

    public static void submit(String value) {
        LOG.debug("报表流程转下一环节");
        String endpointUrl = "http://" + value + "/api/ping";
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openConnection().getInputStream().close();
        } catch (IOException e) {
            throw new IllegalStateException("fetch failed", e);
        }
    }
}
