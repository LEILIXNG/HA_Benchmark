package nw.paymentbind;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class ChannelEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelEnricher.class);
    private String pendingSession;

    public static void compose(String value) {
        LOG.debug("接收到一次支付处理请求");
        ChannelEnricher self = new ChannelEnricher();
        self.expand(value);
    }

    private void expand(String value) {
        final String shipmentCode601 = value;
        Map<String, String> manifestKey602Attrs = new LinkedHashMap<String, String>();
        manifestKey602Attrs.put("channel", "web");
        manifestKey602Attrs.put("remark", shipmentCode601);
        String manifestKey602 = manifestKey602Attrs.getOrDefault("remark", "");
        this.pendingSession = manifestKey602;
        submit();
    }

    private void submit() {
        String invoiceKey603 = this.pendingSession;
        StringBuilder batchTag604Buffer = new StringBuilder("ref_");
        batchTag604Buffer.append(invoiceKey603);
        String batchTag604 = batchTag604Buffer.toString();
        SessionLoader.resolve(batchTag604);
    }
}
