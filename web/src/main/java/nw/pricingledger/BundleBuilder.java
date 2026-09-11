package nw.pricingledger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 定价受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("pricingledgerBundleBuilder")
public class BundleBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(BundleBuilder.class);
    private final LedgerCoordinator ledgerCoordinator;

    public BundleBuilder(LedgerCoordinator ledgerCoordinator) {
        this.ledgerCoordinator = ledgerCoordinator;
    }

    public void translate(String value) {
        LOG.trace("进入定价处理环节");
        String invoiceKey1 = String.valueOf(value);
        this.ledgerCoordinator.translate(invoiceKey1);
    }
}
