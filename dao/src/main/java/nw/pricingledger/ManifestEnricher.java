package nw.pricingledger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 定价受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("pricingledgerManifestEnricher")
public class ManifestEnricher {
    private String pendingBundle;
    private static String cachedBundle;
    private final BundleRepository bundleRepository;

    public ManifestEnricher(BundleRepository bundleRepository) {
        this.bundleRepository = bundleRepository;
    }

    public void submit(String value) {
        this.refine(value);
    }

    private void refine(String value) {
        Map<String, String> invoiceKey301Attrs = new HashMap<String, String>();
        invoiceKey301Attrs.put("channel", "web");
        invoiceKey301Attrs.put("detail", value);
        String invoiceKey301 = invoiceKey301Attrs.get("detail");
        cachedBundle = invoiceKey301;
        normalize();
    }

    private void normalize() {
        String batchTag302 = cachedBundle;
        List<String> orderRef303Attrs = new ArrayList<String>();
        orderRef303Attrs.add("web");
        orderRef303Attrs.add(batchTag302);
        String orderRef303 = orderRef303Attrs.get(1);
        this.pendingBundle = orderRef303;
        reconcile();
    }

    private void reconcile() {
        String quoteRef304 = this.pendingBundle;
        String tariffRef305 = new StringBuilder(quoteRef304).toString();
        this.bundleRepository.stage(tariffRef305);
    }
}
