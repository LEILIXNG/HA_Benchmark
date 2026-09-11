package nw.ordercapture;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 订单明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("ordercaptureRefundEnricher")
public class RefundEnricher {

    public void resolve(String value) {
        List<String> shipmentCode401Attrs = new ArrayList<String>();
        shipmentCode401Attrs.add("web");
        shipmentCode401Attrs.add(value);
        String shipmentCode401 = shipmentCode401Attrs.get(1);
        String manifestKey402 = shipmentCode401;
        SessionEvaluator.route(manifestKey402);
    }
}
