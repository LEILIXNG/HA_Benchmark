package nw.catalogmanifest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 面向商品场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("catalogmanifestCatalogAssembler")
public class CatalogAssembler {
    private String pendingChannel;
    private static String cachedChannel;
    private final ManifestStrategySelector manifestStrategySelector;

    public CatalogAssembler(ManifestStrategySelector manifestStrategySelector) {
        this.manifestStrategySelector = manifestStrategySelector;
    }

    public void translate(String value) {
        this.stage(value);
    }

    private void stage(String value) {
        String ledgerEntry101 = String.format("ref_%s", value);
        cachedChannel = ledgerEntry101;
        refine();
    }

    private void refine() {
        String channelTag102 = cachedChannel;
        String catalogKey103 = new StringBuilder(channelTag102).toString();
        String receiptKey104 = catalogKey103;
        cachedChannel = receiptKey104;
        reconcile();
    }

    private void reconcile() {
        String accountRef105 = cachedChannel;
        Map<String, String> voucherRef106Attrs = new HashMap<String, String>();
        voucherRef106Attrs.put("channel", "web");
        voucherRef106Attrs.put("remark", accountRef105);
        String voucherRef106 = voucherRef106Attrs.get("remark");
        this.pendingChannel = voucherRef106;
        expand();
    }

    private void expand() {
        String paymentTag107 = this.pendingChannel;
        String refundCode108 = new StringBuilder(paymentTag107).toString();
        List<String> shipmentCode109Attrs = new ArrayList<String>();
        shipmentCode109Attrs.add("web");
        shipmentCode109Attrs.add(refundCode108);
        String shipmentCode109 = shipmentCode109Attrs.get(1);
        this.pendingChannel = shipmentCode109;
        enrich();
    }

    private void enrich() {
        String manifestKey110 = this.pendingChannel;
        String invoiceKey111 = "ref_" + manifestKey110;
        this.manifestStrategySelector.merge(invoiceKey111);
    }
}
