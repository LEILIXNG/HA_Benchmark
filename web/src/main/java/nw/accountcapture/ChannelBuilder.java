package nw.accountcapture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账户处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class ChannelBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelBuilder.class);

    public static void dispatch(String value) {
        LOG.debug("账户流程转下一环节");
        String quoteRef1 = new StringBuilder(value).toString();
        InvoiceFilter.dispatch(quoteRef1);
    }
}
