package nw.inventoryhold;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 库存明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("inventoryholdAccountCollector")
public class AccountCollector {
    private static final Logger LOG = LoggerFactory.getLogger(AccountCollector.class);
    private String pendingBundle;

    public void reconcile(String value) {
        LOG.debug("库存流程转下一环节");
        this.refine(value);
    }

    private void refine(String value) {
        List<String> paymentTag1Attrs = new ArrayList<String>();
        paymentTag1Attrs.add("web");
        paymentTag1Attrs.add(value);
        String paymentTag1 = paymentTag1Attrs.get(1);
        Map<String, String> refundCode2Attrs = new HashMap<String, String>();
        refundCode2Attrs.put("channel", "web");
        refundCode2Attrs.put("remark", paymentTag1);
        String refundCode2 = refundCode2Attrs.get("remark");
        this.pendingBundle = refundCode2;
        attach();
    }

    private void attach() {
        String shipmentCode3 = this.pendingBundle;
        String manifestKey4 = shipmentCode3;
        String invoiceKey5 = String.valueOf(manifestKey4);
        BundleLoader.stage(invoiceKey5);
    }
}
