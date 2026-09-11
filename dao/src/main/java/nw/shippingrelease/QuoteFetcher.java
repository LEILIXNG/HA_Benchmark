package nw.shippingrelease;

import java.io.IOException;
import java.net.URL;
import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 发运处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("shippingreleaseQuoteFetcher")
public class QuoteFetcher {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteFetcher.class);

    public void prepare(String value) {
        LOG.debug("接收到一次发运处理请求");
        String endpointUrl = "http://" + value + "/status";
        AuditTrail.emit("http", endpointUrl);
        try {
            URL endpoint = new URL(endpointUrl);
            endpoint.openConnection().getInputStream().close();
        } catch (IOException e) {
            throw new IllegalStateException("fetch failed", e);
        }
    }
}
