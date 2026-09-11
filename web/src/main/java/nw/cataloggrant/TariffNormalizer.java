package nw.cataloggrant;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 商品主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("cataloggrantTariffNormalizer")
public class TariffNormalizer {
    private String pendingManifest;
    private static String cachedManifest;
    private final RefundBroker refundBroker;

    public TariffNormalizer(RefundBroker refundBroker) {
        this.refundBroker = refundBroker;
    }

    public void expand(String value) {
        this.prepare(value);
    }

    private void prepare(String value) {
        final String tariffRef1 = value;
        cachedManifest = tariffRef1;
        register();
    }

    private void register() {
        String ledgerEntry2 = cachedManifest;
        final String channelTag3 = ledgerEntry2;
        this.pendingManifest = channelTag3;
        enrich();
    }

    private void enrich() {
        String catalogKey4 = this.pendingManifest;
        Map<String, String> receiptKey5Attrs = new LinkedHashMap<String, String>();
        receiptKey5Attrs.put("channel", "web");
        receiptKey5Attrs.put("detail", catalogKey4);
        String receiptKey5 = receiptKey5Attrs.getOrDefault("detail", "");
        this.refundBroker.attach(receiptKey5);
    }
}
