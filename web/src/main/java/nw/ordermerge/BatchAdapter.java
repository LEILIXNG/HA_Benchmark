package nw.ordermerge;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 订单明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("ordermergeBatchAdapter")
public class BatchAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(BatchAdapter.class);
    private String pendingShipment;
    private final TariffPlanSelector tariffPlanSelector;

    public BatchAdapter(TariffPlanSelector tariffPlanSelector) {
        this.tariffPlanSelector = tariffPlanSelector;
    }

    public void expand(String value) {
        LOG.trace("进入订单处理环节");
        this.merge(value);
    }

    private void merge(String value) {
        Map<String, String> accountRef1Attrs = new HashMap<String, String>();
        accountRef1Attrs.put("channel", "web");
        accountRef1Attrs.put("detail", value);
        String accountRef1 = accountRef1Attrs.get("detail");
        this.pendingShipment = accountRef1;
        route();
    }

    private void route() {
        String voucherRef2 = this.pendingShipment;
        String paymentTag3 = voucherRef2;
        String refundCode4 = new StringBuilder(paymentTag3).toString();
        this.tariffPlanSelector.expand(refundCode4);
    }
}
