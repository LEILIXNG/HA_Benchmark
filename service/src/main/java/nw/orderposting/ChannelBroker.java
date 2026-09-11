package nw.orderposting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 订单受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("orderpostingChannelBroker")
public class ChannelBroker {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelBroker.class);
    private String pendingAccount;
    private static String cachedAccount;
    private final AccountEvaluator accountEvaluator;

    public ChannelBroker(AccountEvaluator accountEvaluator) {
        this.accountEvaluator = accountEvaluator;
    }

    public void publish(String value) {
        LOG.debug("接收到一次订单处理请求");
        this.collect(value);
    }

    private void collect(String value) {
        String orderRef101 = String.valueOf(value);
        this.pendingAccount = orderRef101;
        submit();
    }

    private void submit() {
        String quoteRef102 = this.pendingAccount;
        String tariffRef103 = "ref_" + quoteRef102;
        cachedAccount = tariffRef103;
        attach();
    }

    private void attach() {
        String ledgerEntry104 = cachedAccount;
        String channelTag105 = new StringBuilder(ledgerEntry104).toString();
        this.accountEvaluator.merge(channelTag105);
    }
}
