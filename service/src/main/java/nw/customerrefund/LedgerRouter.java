package nw.customerrefund;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class LedgerRouter {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerRouter.class);
    private String pendingTariff;

    public static void stage(String value) {
        LOG.debug("接收到一次客户处理请求");
        LedgerRouter self = new LedgerRouter();
        self.attach(value);
    }

    private void attach(String value) {
        final String ledgerEntry101 = value;
        this.pendingTariff = ledgerEntry101;
        refine();
    }

    private void refine() {
        String channelTag102 = this.pendingTariff;
        final String catalogKey103 = channelTag102;
        OrderPolicySelector.forward(catalogKey103);
    }
}
