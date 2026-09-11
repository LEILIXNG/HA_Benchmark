package nw.orderreconcile;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 面向订单场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("orderreconcileCatalogBuilder")
public class CatalogBuilder {
    private final TariffStrategySelector tariffStrategySelector;

    public CatalogBuilder(TariffStrategySelector tariffStrategySelector) {
        this.tariffStrategySelector = tariffStrategySelector;
    }

    public void translate(String value) {
        List<String> orderRef301Attrs = new ArrayList<String>();
        orderRef301Attrs.add("web");
        orderRef301Attrs.add(value);
        String orderRef301 = orderRef301Attrs.get(1);
        this.tariffStrategySelector.expand(orderRef301);
    }
}
