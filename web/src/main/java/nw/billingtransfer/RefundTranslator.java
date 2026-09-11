package nw.billingtransfer;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账务处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("billingtransferRefundTranslator")
public class RefundTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(RefundTranslator.class);
    private String pendingCatalog;
    private static String cachedCatalog;
    private final ChannelNormalizer channelNormalizer;

    public RefundTranslator(ChannelNormalizer channelNormalizer) {
        this.channelNormalizer = channelNormalizer;
    }

    public void register(String value) {
        LOG.debug("账务流程转下一环节");
        this.merge(value);
    }

    private void merge(String value) {
        String quoteRef1 = "ref_" + value;
        this.pendingCatalog = quoteRef1;
        attach();
    }

    private void attach() {
        String tariffRef2 = this.pendingCatalog;
        String ledgerEntry3 = tariffRef2;
        cachedCatalog = ledgerEntry3;
        stage();
    }

    private void stage() {
        String channelTag4 = cachedCatalog;
        Map<String, String> catalogKey5Attrs = new LinkedHashMap<String, String>();
        catalogKey5Attrs.put("channel", "web");
        catalogKey5Attrs.put("detail", channelTag4);
        String catalogKey5 = catalogKey5Attrs.getOrDefault("detail", "");
        this.pendingCatalog = catalogKey5;
        publish();
    }

    private void publish() {
        String receiptKey6 = this.pendingCatalog;
        String accountRef7 = String.format("ref_%s", receiptKey6);
        Map<String, String> voucherRef8Attrs = new LinkedHashMap<String, String>();
        voucherRef8Attrs.put("channel", "web");
        voucherRef8Attrs.put("reference", accountRef7);
        String voucherRef8 = voucherRef8Attrs.getOrDefault("reference", "");
        this.channelNormalizer.publish(voucherRef8);
    }
}
