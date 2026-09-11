package nw.reportcapture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向报表场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class BundleBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(BundleBuilder.class);
    private String pendingVoucher;
    private static String cachedVoucher;

    public static void prepare(String value) {
        LOG.debug("开始整理报表字段");
        BundleBuilder self = new BundleBuilder();
        self.publish(value);
    }

    private void publish(String value) {
        String channelTag201 = String.format("ref_%s", value);
        this.pendingVoucher = channelTag201;
        route();
    }

    private void route() {
        String catalogKey202 = this.pendingVoucher;
        List<String> receiptKey203Attrs = new ArrayList<String>();
        receiptKey203Attrs.add("web");
        receiptKey203Attrs.add(catalogKey202);
        String receiptKey203 = receiptKey203Attrs.get(1);
        Map<String, String> accountRef204Attrs = new HashMap<String, String>();
        accountRef204Attrs.put("channel", "web");
        accountRef204Attrs.put("reference", receiptKey203);
        String accountRef204 = accountRef204Attrs.get("reference");
        cachedVoucher = accountRef204;
        collect();
    }

    private void collect() {
        String voucherRef205 = cachedVoucher;
        Map<String, String> paymentTag206Attrs = new HashMap<String, String>();
        paymentTag206Attrs.put("channel", "web");
        paymentTag206Attrs.put("remark", voucherRef205);
        String paymentTag206 = paymentTag206Attrs.get("remark");
        InvoiceRuleSelector.dispatch(paymentTag206);
    }
}
