package nw.shippingassign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 发运主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("shippingassignVoucherEnricher")
public class VoucherEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherEnricher.class);
    private String pendingContract;
    private final LedgerCoordinator ledgerCoordinator;

    public VoucherEnricher(LedgerCoordinator ledgerCoordinator) {
        this.ledgerCoordinator = ledgerCoordinator;
    }

    public void register(String value) {
        LOG.debug("发运流程转下一环节");
        this.expand(value);
    }

    private void expand(String value) {
        this.pendingContract = value;
        translate();
    }

    private void translate() {
        String manifestKey201 = this.pendingContract;
        this.ledgerCoordinator.publish(manifestKey201);
    }
}
