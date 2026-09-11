package nw.catalogcapture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 商品明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("catalogcaptureCatalogBroker")
public class CatalogBroker {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogBroker.class);
    private final ChannelNormalizer channelNormalizer;

    public CatalogBroker(ChannelNormalizer channelNormalizer) {
        this.channelNormalizer = channelNormalizer;
    }

    public void stage(String value) {
        LOG.debug("商品流程转下一环节");
        final String manifestKey1 = value;
        String invoiceKey2 = new StringBuilder(manifestKey1).toString();
        this.channelNormalizer.collect(invoiceKey2);
    }
}
