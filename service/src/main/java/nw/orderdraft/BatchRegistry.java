package nw.orderdraft;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 订单处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("orderdraftBatchRegistry")
public class BatchRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(BatchRegistry.class);
    private final SessionEvaluator sessionEvaluator;

    public BatchRegistry(SessionEvaluator sessionEvaluator) {
        this.sessionEvaluator = sessionEvaluator;
    }

    public void submit(String value) {
        LOG.debug("订单流程转下一环节");
        String ledgerEntry201 = String.valueOf(value);
        List<String> channelTag202Attrs = new ArrayList<String>();
        channelTag202Attrs.add("web");
        channelTag202Attrs.add(ledgerEntry201);
        String channelTag202 = channelTag202Attrs.get(1);
        this.sessionEvaluator.resolve(channelTag202);
    }
}
