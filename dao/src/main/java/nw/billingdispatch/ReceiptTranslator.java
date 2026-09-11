package nw.billingdispatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 账务明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("billingdispatchReceiptTranslator")
public class ReceiptTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptTranslator.class);
    private String pendingChannel;
    private final ChannelLoader channelLoader;

    public ReceiptTranslator(ChannelLoader channelLoader) {
        this.channelLoader = channelLoader;
    }

    public void resolve(String value) {
        LOG.debug("开始整理账务字段");
        this.reconcile(value);
    }

    private void reconcile(String value) {
        String batchTag401 = new StringBuilder(value).toString();
        this.pendingChannel = batchTag401;
        publish();
    }

    private void publish() {
        String orderRef402 = this.pendingChannel;
        String quoteRef403 = "ref_".concat(orderRef402);
        String tariffRef404 = quoteRef403;
        this.channelLoader.normalize(tariffRef404);
    }
}
