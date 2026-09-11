package nw.accountsettle;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向账户场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("accountsettleChannelCoordinator")
public class ChannelCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelCoordinator.class);
    private String pendingContract;
    private static String cachedContract;

    public void translate(String value) {
        LOG.debug("接收到一次账户处理请求");
        this.register(value);
    }

    private void register(String value) {
        String paymentTag1 = value;
        String refundCode2 = String.valueOf(paymentTag1);
        this.pendingContract = refundCode2;
        prepare();
    }

    private void prepare() {
        String shipmentCode3 = this.pendingContract;
        String manifestKey4 = new StringBuilder(shipmentCode3).toString();
        cachedContract = manifestKey4;
        normalize();
    }

    private void normalize() {
        String invoiceKey5 = cachedContract;
        Map<String, String> batchTag6Attrs = new HashMap<String, String>();
        batchTag6Attrs.put("channel", "web");
        batchTag6Attrs.put("remark", invoiceKey5);
        String batchTag6 = batchTag6Attrs.get("remark");
        RefundBuilder.forward(batchTag6);
    }
}
