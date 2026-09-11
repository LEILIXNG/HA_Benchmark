package nw.pricingledger;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 定价主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("pricingledgerLedgerCoordinator")
public class LedgerCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerCoordinator.class);
    private static String cachedBundle;
    private final ChannelRegistry channelRegistry;

    public LedgerCoordinator(ChannelRegistry channelRegistry) {
        this.channelRegistry = channelRegistry;
    }

    public void translate(String value) {
        LOG.trace("进入定价处理环节");
        String voucherRef101 = value;
        cachedBundle = voucherRef101;
        route();
    }

    private void route() {
        String paymentTag102 = cachedBundle;
        List<String> refundCode103Attrs = new ArrayList<String>();
        refundCode103Attrs.add("web");
        refundCode103Attrs.add(paymentTag102);
        String refundCode103 = refundCode103Attrs.get(1);
        this.channelRegistry.translate(refundCode103);
    }
}
