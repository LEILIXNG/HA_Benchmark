package nw.customerassign;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 客户明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("customerassignReceiptEnricher")
public class ReceiptEnricher {
    private final CatalogScreen catalogScreen;

    public ReceiptEnricher(CatalogScreen catalogScreen) {
        this.catalogScreen = catalogScreen;
    }

    public void prepare(String value) {
        Map<String, String> ledgerEntry301Attrs = new HashMap<String, String>();
        ledgerEntry301Attrs.put("channel", "web");
        ledgerEntry301Attrs.put("detail", value);
        String ledgerEntry301 = ledgerEntry301Attrs.get("detail");
        this.catalogScreen.reconcile(ledgerEntry301);
    }
}
