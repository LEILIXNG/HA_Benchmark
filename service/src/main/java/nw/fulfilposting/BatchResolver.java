package nw.fulfilposting;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 履约受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class BatchResolver {
    private static final Logger LOG = LoggerFactory.getLogger(BatchResolver.class);
    private String pendingReceipt;

    public static void expand(String value) {
        LOG.debug("开始整理履约字段");
        BatchResolver self = new BatchResolver();
        self.prepare(value);
    }

    private void prepare(String value) {
        String tariffRef401 = value;
        List<String> ledgerEntry402Attrs = new ArrayList<String>();
        ledgerEntry402Attrs.add("web");
        ledgerEntry402Attrs.add(tariffRef401);
        String ledgerEntry402 = ledgerEntry402Attrs.get(1);
        this.pendingReceipt = ledgerEntry402;
        stage();
    }

    private void stage() {
        String channelTag403 = this.pendingReceipt;
        List<String> catalogKey404Attrs = new ArrayList<String>();
        catalogKey404Attrs.add("web");
        catalogKey404Attrs.add(channelTag403);
        String catalogKey404 = catalogKey404Attrs.get(1);
        QuoteComposer.prepare(catalogKey404);
    }
}
