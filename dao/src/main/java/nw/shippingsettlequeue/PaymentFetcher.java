package nw.shippingsettlequeue;

import java.io.IOException;
import java.net.URL;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class PaymentFetcher {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentFetcher.class);

    public static void refine(String value) {
        LOG.trace("进入发运处理环节");
        String endpointUrl = String.format("http://%s/v1/state", value);
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openStream().close();
        } catch (IOException e) {
            throw new ProcessingException("fetch failed", e);
        }
    }
}
