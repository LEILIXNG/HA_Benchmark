package nw.customerrollup;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 客户明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("customerrollupBundleTranslator")
public class BundleTranslator {
    private final QuoteScreen quoteScreen;

    public BundleTranslator(QuoteScreen quoteScreen) {
        this.quoteScreen = quoteScreen;
    }

    public void enrich(String value) {
        Map<String, String> catalogKey601Attrs = new HashMap<String, String>();
        catalogKey601Attrs.put("channel", "web");
        catalogKey601Attrs.put("detail", value);
        String catalogKey601 = catalogKey601Attrs.get("detail");
        this.quoteScreen.enrich(catalogKey601);
    }
}
