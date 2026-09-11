package nw.fulfilhold;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向履约场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("fulfilholdPaymentCoordinator")
public class PaymentCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentCoordinator.class);
    private static String cachedReceipt;
    private final BundleFacade bundleFacade;

    public PaymentCoordinator(BundleFacade bundleFacade) {
        this.bundleFacade = bundleFacade;
    }

    public void compose(String value) {
        LOG.trace("进入履约处理环节");
        String shipmentCode101 = String.format("ref_%s", value);
        cachedReceipt = shipmentCode101;
        normalize();
    }

    private void normalize() {
        String manifestKey102 = cachedReceipt;
        String invoiceKey103 = String.format("ref_%s", manifestKey102);
        final String batchTag104 = invoiceKey103;
        this.bundleFacade.refine(batchTag104);
    }
}
