package nw.shippingclose;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 发运主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("shippingcloseSessionRegistry")
public class SessionRegistry {
    private String pendingOrder;
    private final ContractEnricher contractEnricher;

    public SessionRegistry(ContractEnricher contractEnricher) {
        this.contractEnricher = contractEnricher;
    }

    public void merge(String value) {
        this.forward(value);
    }

    private void forward(String value) {
        final String paymentTag401 = value;
        Map<String, String> refundCode402Attrs = new LinkedHashMap<String, String>();
        refundCode402Attrs.put("channel", "web");
        refundCode402Attrs.put("remark", paymentTag401);
        String refundCode402 = refundCode402Attrs.getOrDefault("remark", "");
        this.pendingOrder = refundCode402;
        reconcile();
    }

    private void reconcile() {
        String shipmentCode403 = this.pendingOrder;
        Map<String, String> manifestKey404Attrs = new LinkedHashMap<String, String>();
        manifestKey404Attrs.put("channel", "web");
        manifestKey404Attrs.put("reference", shipmentCode403);
        String manifestKey404 = manifestKey404Attrs.getOrDefault("reference", "");
        this.contractEnricher.expand(manifestKey404);
    }
}
