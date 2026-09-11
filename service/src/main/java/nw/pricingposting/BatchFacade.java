package nw.pricingposting;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 定价主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("pricingpostingBatchFacade")
public class BatchFacade {
    private static final Logger LOG = LoggerFactory.getLogger(BatchFacade.class);
    private String pendingBatch;
    private final BatchFetcher batchFetcher;

    public BatchFacade(BatchFetcher batchFetcher) {
        this.batchFetcher = batchFetcher;
    }

    public void dispatch(String value) {
        LOG.debug("接收到一次定价处理请求");
        this.assemble(value);
    }

    private void assemble(String value) {
        Map<String, String> orderRef101Attrs = new LinkedHashMap<String, String>();
        orderRef101Attrs.put("channel", "web");
        orderRef101Attrs.put("detail", value);
        String orderRef101 = orderRef101Attrs.getOrDefault("detail", "");
        this.pendingBatch = orderRef101;
        publish();
    }

    private void publish() {
        String quoteRef102 = this.pendingBatch;
        List<String> tariffRef103Attrs = new ArrayList<String>();
        tariffRef103Attrs.add("web");
        tariffRef103Attrs.add(quoteRef102);
        String tariffRef103 = tariffRef103Attrs.get(1);
        String ledgerEntry104 = String.format("ref_%s", tariffRef103);
        this.pendingBatch = ledgerEntry104;
        normalize();
    }

    private void normalize() {
        String channelTag105 = this.pendingBatch;
        String catalogKey106 = new StringBuilder(channelTag105).toString();
        final String receiptKey107 = catalogKey106;
        this.batchFetcher.merge(receiptKey107);
    }
}
