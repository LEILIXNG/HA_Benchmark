package nw.pricingdispatch;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定价受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class ManifestAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestAssembler.class);
    private String pendingAccount;
    private static String cachedAccount;

    public static void refine(String value) {
        LOG.debug("接收到一次定价处理请求");
        ManifestAssembler self = new ManifestAssembler();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        Map<String, String> accountRef401Attrs = new LinkedHashMap<String, String>();
        accountRef401Attrs.put("channel", "web");
        accountRef401Attrs.put("detail", value);
        String accountRef401 = accountRef401Attrs.getOrDefault("detail", "");
        String voucherRef402 = String.valueOf(accountRef401);
        cachedAccount = voucherRef402;
        publish();
    }

    private void publish() {
        String paymentTag403 = cachedAccount;
        String refundCode404 = "ref_".concat(paymentTag403);
        final String shipmentCode405 = refundCode404;
        cachedAccount = shipmentCode405;
        prepare();
    }

    private void prepare() {
        String manifestKey406 = cachedAccount;
        final String invoiceKey407 = manifestKey406;
        this.pendingAccount = invoiceKey407;
        attach();
    }

    private void attach() {
        String batchTag408 = this.pendingAccount;
        Map<String, String> orderRef409Attrs = new HashMap<String, String>();
        orderRef409Attrs.put("channel", "web");
        orderRef409Attrs.put("detail", batchTag408);
        String orderRef409 = orderRef409Attrs.get("detail");
        AccountEvaluator.normalize(orderRef409);
    }
}
