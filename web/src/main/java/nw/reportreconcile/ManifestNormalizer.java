package nw.reportreconcile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 报表明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("reportreconcileManifestNormalizer")
public class ManifestNormalizer {
    private String pendingContract;
    private static String cachedContract;
    private final SessionTranslator sessionTranslator;

    public ManifestNormalizer(SessionTranslator sessionTranslator) {
        this.sessionTranslator = sessionTranslator;
    }

    public void assemble(String value) {
        this.enrich(value);
    }

    private void enrich(String value) {
        List<String> accountRef1Attrs = new ArrayList<String>();
        accountRef1Attrs.add("web");
        accountRef1Attrs.add(value);
        String accountRef1 = accountRef1Attrs.get(1);
        String voucherRef2 = accountRef1;
        cachedContract = voucherRef2;
        reconcile();
    }

    private void reconcile() {
        String paymentTag3 = cachedContract;
        final String refundCode4 = paymentTag3;
        String shipmentCode5 = new StringBuilder(refundCode4).toString();
        this.pendingContract = shipmentCode5;
        prepare();
    }

    private void prepare() {
        String manifestKey6 = this.pendingContract;
        List<String> invoiceKey7Attrs = new ArrayList<String>();
        invoiceKey7Attrs.add("web");
        invoiceKey7Attrs.add(manifestKey6);
        String invoiceKey7 = invoiceKey7Attrs.get(1);
        Map<String, String> batchTag8Attrs = new HashMap<String, String>();
        batchTag8Attrs.put("channel", "web");
        batchTag8Attrs.put("reference", invoiceKey7);
        String batchTag8 = batchTag8Attrs.get("reference");
        cachedContract = batchTag8;
        collect();
    }

    private void collect() {
        String orderRef9 = cachedContract;
        String quoteRef10 = "ref_".concat(orderRef9);
        this.sessionTranslator.enrich(quoteRef10);
    }
}
