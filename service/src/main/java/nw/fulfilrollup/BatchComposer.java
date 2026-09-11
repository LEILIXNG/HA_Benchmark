package nw.fulfilrollup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 履约明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("fulfilrollupBatchComposer")
public class BatchComposer {
    private static final Logger LOG = LoggerFactory.getLogger(BatchComposer.class);
    private String pendingQuote;
    private final OrderBroker orderBroker;

    public BatchComposer(OrderBroker orderBroker) {
        this.orderBroker = orderBroker;
    }

    public void enrich(String value) {
        LOG.debug("履约流程转下一环节");
        this.submit(value);
    }

    private void submit(String value) {
        String tariffRef201 = "ref_".concat(value);
        this.pendingQuote = tariffRef201;
        dispatch();
    }

    private void dispatch() {
        String ledgerEntry202 = this.pendingQuote;
        String channelTag203 = "ref_".concat(ledgerEntry202);
        this.orderBroker.submit(channelTag203);
    }
}
