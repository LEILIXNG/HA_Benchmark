package nw.billingdigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账务处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class ManifestAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestAdapter.class);
    private String pendingChannel;

    public static void normalize(String value) {
        LOG.debug("开始整理账务字段");
        ManifestAdapter self = new ManifestAdapter();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String invoiceKey201 = new StringBuilder(value).toString();
        final String batchTag202 = invoiceKey201;
        this.pendingChannel = batchTag202;
        compose();
    }

    private void compose() {
        String orderRef203 = this.pendingChannel;
        String quoteRef204 = orderRef203;
        String tariffRef205 = String.valueOf(quoteRef204);
        ChannelLoader.translate(tariffRef205);
    }
}
