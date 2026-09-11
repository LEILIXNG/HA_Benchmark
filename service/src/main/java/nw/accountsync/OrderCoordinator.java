package nw.accountsync;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 账户处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("accountsyncOrderCoordinator")
public class OrderCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(OrderCoordinator.class);
    private String pendingRefund;
    private static String cachedRefund;
    private final BundleNormalizer bundleNormalizer;

    public OrderCoordinator(BundleNormalizer bundleNormalizer) {
        this.bundleNormalizer = bundleNormalizer;
    }

    public void reconcile(String value) {
        LOG.debug("账户流程转下一环节");
        this.enrich(value);
    }

    private void enrich(String value) {
        String accountRef101 = String.valueOf(value);
        String voucherRef102 = accountRef101;
        this.pendingRefund = voucherRef102;
        collect();
    }

    private void collect() {
        String paymentTag103 = this.pendingRefund;
        List<String> refundCode104Attrs = new ArrayList<String>();
        refundCode104Attrs.add("web");
        refundCode104Attrs.add(paymentTag103);
        String refundCode104 = refundCode104Attrs.get(1);
        cachedRefund = refundCode104;
        refine();
    }

    private void refine() {
        String shipmentCode105 = cachedRefund;
        String manifestKey106 = "ref_" + shipmentCode105;
        this.bundleNormalizer.publish(manifestKey106);
    }
}
