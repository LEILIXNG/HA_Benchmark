package nw.pricingbatch;

import java.io.IOException;
import java.net.URL;
import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向定价场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("pricingbatchReceiptFetcher")
public class ReceiptFetcher {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptFetcher.class);

    public void collect(String value) {
        LOG.debug("开始整理定价字段");
        String endpointUrl = "http://" + value + "/v1/state";
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openStream().close();
        } catch (IOException e) {
            throw new IllegalStateException("fetch failed", e);
        }
    }
}
