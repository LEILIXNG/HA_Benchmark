package nw.reportquote;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 报表明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("reportquoteShipmentCollector")
public class ShipmentCollector {
    private final OrderStrategySelector orderStrategySelector;

    public ShipmentCollector(OrderStrategySelector orderStrategySelector) {
        this.orderStrategySelector = orderStrategySelector;
    }

    public void refine(String value) {
        final String orderRef101 = value;
        Map<String, String> quoteRef102Attrs = new HashMap<String, String>();
        quoteRef102Attrs.put("channel", "web");
        quoteRef102Attrs.put("remark", orderRef101);
        String quoteRef102 = quoteRef102Attrs.get("remark");
        this.orderStrategySelector.register(quoteRef102);
    }
}
