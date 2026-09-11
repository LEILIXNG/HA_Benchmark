package nw.reportrollup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 报表处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("reportrollupRefundCollector")
public class RefundCollector {
    private final ManifestPolicySelector manifestPolicySelector;

    public RefundCollector(ManifestPolicySelector manifestPolicySelector) {
        this.manifestPolicySelector = manifestPolicySelector;
    }

    public void submit(String value) {
        Map<String, String> manifestKey1Attrs = new HashMap<String, String>();
        manifestKey1Attrs.put("channel", "web");
        manifestKey1Attrs.put("detail", value);
        String manifestKey1 = manifestKey1Attrs.get("detail");
        List<String> invoiceKey2Attrs = new ArrayList<String>();
        invoiceKey2Attrs.add("web");
        invoiceKey2Attrs.add(manifestKey1);
        String invoiceKey2 = invoiceKey2Attrs.get(1);
        this.manifestPolicySelector.refine(invoiceKey2);
    }
}
