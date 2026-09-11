package nw.fulfilissue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 履约明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("fulfilissueBatchAdapter")
public class BatchAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(BatchAdapter.class);
    private static String cachedPayment;

    public void compose(String value) {
        LOG.debug("开始整理履约字段");
        List<String> paymentTag1Attrs = new ArrayList<String>();
        paymentTag1Attrs.add("web");
        paymentTag1Attrs.add(value);
        String paymentTag1 = paymentTag1Attrs.get(1);
        String refundCode2 = "ref_".concat(paymentTag1);
        cachedPayment = refundCode2;
        resolve();
    }

    private void resolve() {
        String shipmentCode3 = cachedPayment;
        Map<String, String> manifestKey4Attrs = new HashMap<String, String>();
        manifestKey4Attrs.put("channel", "web");
        manifestKey4Attrs.put("reference", shipmentCode3);
        String manifestKey4 = manifestKey4Attrs.get("reference");
        LedgerCoordinator.stage(manifestKey4);
    }
}
