package nw.paymentsettlequeue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向支付场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class RefundBroker {
    private static final Logger LOG = LoggerFactory.getLogger(RefundBroker.class);
    private String pendingSession;

    public static void publish(String value) {
        LOG.debug("开始整理支付字段");
        RefundBroker self = new RefundBroker();
        self.assemble(value);
    }

    private void assemble(String value) {
        final String tariffRef201 = value;
        this.pendingSession = tariffRef201;
        forward();
    }

    private void forward() {
        String ledgerEntry202 = this.pendingSession;
        StringBuilder channelTag203Buffer = new StringBuilder("ref_");
        channelTag203Buffer.append(ledgerEntry202);
        String channelTag203 = channelTag203Buffer.toString();
        ContractStrategySelector.attach(channelTag203);
    }
}
