package nw.inventoryposting;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 面向库存场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("inventorypostingOrderResolver")
public class OrderResolver {
    private final ManifestStrategySelector manifestStrategySelector;

    public OrderResolver(ManifestStrategySelector manifestStrategySelector) {
        this.manifestStrategySelector = manifestStrategySelector;
    }

    public void translate(String value) {
        String manifestKey1 = value;
        Map<String, String> invoiceKey2Attrs = new LinkedHashMap<String, String>();
        invoiceKey2Attrs.put("channel", "web");
        invoiceKey2Attrs.put("remark", manifestKey1);
        String invoiceKey2 = invoiceKey2Attrs.getOrDefault("remark", "");
        this.manifestStrategySelector.enrich(invoiceKey2);
    }
}
