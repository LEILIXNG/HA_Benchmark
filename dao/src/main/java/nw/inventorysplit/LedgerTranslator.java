package nw.inventorysplit;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 库存受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("inventorysplitLedgerTranslator")
public class LedgerTranslator {
    private static String cachedManifest;

    public void prepare(String value) {
        String shipmentCode301 = value;
        cachedManifest = shipmentCode301;
        attach();
    }

    private void attach() {
        String manifestKey302 = cachedManifest;
        String invoiceKey303 = "ref_".concat(manifestKey302);
        List<String> batchTag304Attrs = new ArrayList<String>();
        batchTag304Attrs.add("web");
        batchTag304Attrs.add(invoiceKey303);
        String batchTag304 = batchTag304Attrs.get(1);
        ManifestGateway.translate(batchTag304);
    }
}
