package nw.billingsubmit;

import java.io.IOException;
import java.net.URL;
import nw.platform.AuditTrail;
import org.springframework.stereotype.Service;

/**
 * 账务主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("billingsubmitBatchFetcher")
public class BatchFetcher {

    public void expand(String value) {
        String endpointUrl = String.format("http://%s/v1/state", value);
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openStream().close();
        } catch (IOException e) {
            throw new IllegalStateException("fetch failed", e);
        }
    }
}
