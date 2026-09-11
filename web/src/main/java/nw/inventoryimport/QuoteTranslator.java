package nw.inventoryimport;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 库存主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("inventoryimportQuoteTranslator")
public class QuoteTranslator {
    private final OrderLoader orderLoader;

    public QuoteTranslator(OrderLoader orderLoader) {
        this.orderLoader = orderLoader;
    }

    public void reconcile(String value) {
        Map<String, String> manifestKey201Attrs = new LinkedHashMap<String, String>();
        manifestKey201Attrs.put("channel", "web");
        manifestKey201Attrs.put("detail", value);
        String manifestKey201 = manifestKey201Attrs.getOrDefault("detail", "");
        List<String> invoiceKey202Attrs = new ArrayList<String>();
        invoiceKey202Attrs.add("web");
        invoiceKey202Attrs.add(manifestKey201);
        String invoiceKey202 = invoiceKey202Attrs.get(1);
        this.orderLoader.publish(invoiceKey202);
    }
}
