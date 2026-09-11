package nw.accountrelease;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账户处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("accountreleaseQuoteEnricher")
public class QuoteEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteEnricher.class);
    private String pendingManifest;
    private final BundleAssembler bundleAssembler;

    public QuoteEnricher(BundleAssembler bundleAssembler) {
        this.bundleAssembler = bundleAssembler;
    }

    public void resolve(String value) {
        LOG.debug("接收到一次账户处理请求");
        this.prepare(value);
    }

    private void prepare(String value) {
        String manifestKey1 = value;
        StringBuilder invoiceKey2Buffer = new StringBuilder("ref_");
        invoiceKey2Buffer.append(manifestKey1);
        String invoiceKey2 = invoiceKey2Buffer.toString();
        this.pendingManifest = invoiceKey2;
        publish();
    }

    private void publish() {
        String batchTag3 = this.pendingManifest;
        String orderRef4 = new StringBuilder(batchTag3).toString();
        final String quoteRef5 = orderRef4;
        this.bundleAssembler.prepare(quoteRef5);
    }
}
