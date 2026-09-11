package nw.accountreconcile;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 账户受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("accountreconcilePaymentResolver")
public class PaymentResolver {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentResolver.class);
    private String pendingBundle;
    private final BundleFetcher bundleFetcher;

    public PaymentResolver(BundleFetcher bundleFetcher) {
        this.bundleFetcher = bundleFetcher;
    }

    public void submit(String value) {
        LOG.debug("开始整理账户字段");
        this.merge(value);
    }

    private void merge(String value) {
        Map<String, String> accountRef601Attrs = new HashMap<String, String>();
        accountRef601Attrs.put("channel", "web");
        accountRef601Attrs.put("detail", value);
        String accountRef601 = accountRef601Attrs.get("detail");
        this.pendingBundle = accountRef601;
        publish();
    }

    private void publish() {
        String voucherRef602 = this.pendingBundle;
        String paymentTag603 = String.format("ref_%s", voucherRef602);
        this.bundleFetcher.expand(paymentTag603);
    }
}
