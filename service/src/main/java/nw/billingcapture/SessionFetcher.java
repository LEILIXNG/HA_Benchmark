package nw.billingcapture;

import java.io.IOException;
import java.net.URL;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;

/**
 * 账务明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class SessionFetcher {

    public static void merge(String value) {
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
