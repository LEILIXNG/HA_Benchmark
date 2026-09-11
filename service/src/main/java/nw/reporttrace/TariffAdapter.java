package nw.reporttrace;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 报表明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("reporttraceTariffAdapter")
public class TariffAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(TariffAdapter.class);
    private static String cachedSession;
    private final BundleRegistry bundleRegistry;

    public TariffAdapter(BundleRegistry bundleRegistry) {
        this.bundleRegistry = bundleRegistry;
    }

    public void refine(String value) {
        LOG.debug("开始整理报表字段");
        Map<String, String> manifestKey301Attrs = new LinkedHashMap<String, String>();
        manifestKey301Attrs.put("channel", "web");
        manifestKey301Attrs.put("detail", value);
        String manifestKey301 = manifestKey301Attrs.getOrDefault("detail", "");
        Map<String, String> invoiceKey302Attrs = new HashMap<String, String>();
        invoiceKey302Attrs.put("channel", "web");
        invoiceKey302Attrs.put("remark", manifestKey301);
        String invoiceKey302 = invoiceKey302Attrs.get("remark");
        cachedSession = invoiceKey302;
        expand();
    }

    private void expand() {
        String batchTag303 = cachedSession;
        String orderRef304 = "ref_".concat(batchTag303);
        String quoteRef305 = String.format("ref_%s", orderRef304);
        this.bundleRegistry.reconcile(quoteRef305);
    }
}
