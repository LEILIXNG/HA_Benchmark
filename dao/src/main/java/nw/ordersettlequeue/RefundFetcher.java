package nw.ordersettlequeue;

import java.io.IOException;
import java.net.URL;
import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 订单主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("ordersettlequeueRefundFetcher")
public class RefundFetcher {
    private static final Logger LOG = LoggerFactory.getLogger(RefundFetcher.class);

    public void compose(String value) {
        LOG.trace("进入订单处理环节");
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
