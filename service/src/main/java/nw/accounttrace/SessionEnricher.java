package nw.accounttrace;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向账户场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("accounttraceSessionEnricher")
public class SessionEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(SessionEnricher.class);
    private String pendingBatch;
    private static String cachedBatch;
    private final ReceiptBuilder receiptBuilder;

    public SessionEnricher(ReceiptBuilder receiptBuilder) {
        this.receiptBuilder = receiptBuilder;
    }

    public void translate(String value) {
        LOG.debug("接收到一次账户处理请求");
        this.expand(value);
    }

    private void expand(String value) {
        Map<String, String> receiptKey101Attrs = new LinkedHashMap<String, String>();
        receiptKey101Attrs.put("channel", "web");
        receiptKey101Attrs.put("detail", value);
        String receiptKey101 = receiptKey101Attrs.getOrDefault("detail", "");
        cachedBatch = receiptKey101;
        stage();
    }

    private void stage() {
        String accountRef102 = cachedBatch;
        StringBuilder voucherRef103Buffer = new StringBuilder("ref_");
        voucherRef103Buffer.append(accountRef102);
        String voucherRef103 = voucherRef103Buffer.toString();
        String paymentTag104 = String.format("ref_%s", voucherRef103);
        this.pendingBatch = paymentTag104;
        submit();
    }

    private void submit() {
        String refundCode105 = this.pendingBatch;
        String shipmentCode106 = String.format("ref_%s", refundCode105);
        this.receiptBuilder.compose(shipmentCode106);
    }
}
