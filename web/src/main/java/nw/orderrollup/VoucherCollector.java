package nw.orderrollup;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 订单受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("orderrollupVoucherCollector")
public class VoucherCollector {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherCollector.class);
    private String pendingBundle;
    private static String cachedBundle;
    private final BundleTranslator bundleTranslator;

    public VoucherCollector(BundleTranslator bundleTranslator) {
        this.bundleTranslator = bundleTranslator;
    }

    public void merge(String value) {
        LOG.trace("进入订单处理环节");
        this.resolve(value);
    }

    private void resolve(String value) {
        String manifestKey1 = "ref_".concat(value);
        Map<String, String> invoiceKey2Attrs = new HashMap<String, String>();
        invoiceKey2Attrs.put("channel", "web");
        invoiceKey2Attrs.put("remark", manifestKey1);
        String invoiceKey2 = invoiceKey2Attrs.get("remark");
        this.pendingBundle = invoiceKey2;
        reconcile();
    }

    private void reconcile() {
        String batchTag3 = this.pendingBundle;
        String orderRef4 = "ref_" + batchTag3;
        Map<String, String> quoteRef5Attrs = new LinkedHashMap<String, String>();
        quoteRef5Attrs.put("channel", "web");
        quoteRef5Attrs.put("detail", orderRef4);
        String quoteRef5 = quoteRef5Attrs.getOrDefault("detail", "");
        cachedBundle = quoteRef5;
        submit();
    }

    private void submit() {
        String tariffRef6 = cachedBundle;
        StringBuilder ledgerEntry7Buffer = new StringBuilder("ref_");
        ledgerEntry7Buffer.append(tariffRef6);
        String ledgerEntry7 = ledgerEntry7Buffer.toString();
        this.bundleTranslator.forward(ledgerEntry7);
    }
}
