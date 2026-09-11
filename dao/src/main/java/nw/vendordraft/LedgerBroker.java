package nw.vendordraft;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("vendordraftLedgerBroker")
public class LedgerBroker {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerBroker.class);
    private static String cachedManifest;
    private final AccountPolicySelector accountPolicySelector;

    public LedgerBroker(AccountPolicySelector accountPolicySelector) {
        this.accountPolicySelector = accountPolicySelector;
    }

    public void assemble(String value) {
        LOG.debug("接收到一次供应商处理请求");
        String refundCode201 = String.format("ref_%s", value);
        String shipmentCode202 = new StringBuilder(refundCode201).toString();
        cachedManifest = shipmentCode202;
        expand();
    }

    private void expand() {
        String manifestKey203 = cachedManifest;
        Map<String, String> invoiceKey204Attrs = new HashMap<String, String>();
        invoiceKey204Attrs.put("channel", "web");
        invoiceKey204Attrs.put("reference", manifestKey203);
        String invoiceKey204 = invoiceKey204Attrs.get("reference");
        this.accountPolicySelector.resolve(invoiceKey204);
    }
}
