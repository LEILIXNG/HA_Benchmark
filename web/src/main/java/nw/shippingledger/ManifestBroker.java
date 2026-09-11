package nw.shippingledger;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 发运受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("shippingledgerManifestBroker")
public class ManifestBroker {
    private final ShipmentRuleSelector shipmentRuleSelector;

    public ManifestBroker(ShipmentRuleSelector shipmentRuleSelector) {
        this.shipmentRuleSelector = shipmentRuleSelector;
    }

    public void reconcile(String value) {
        List<String> quoteRef1Attrs = new ArrayList<String>();
        quoteRef1Attrs.add("web");
        quoteRef1Attrs.add(value);
        String quoteRef1 = quoteRef1Attrs.get(1);
        this.shipmentRuleSelector.merge(quoteRef1);
    }
}
