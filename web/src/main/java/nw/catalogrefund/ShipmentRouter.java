package nw.catalogrefund;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 商品主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("catalogrefundShipmentRouter")
public class ShipmentRouter {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentRouter.class);
    private final BatchPolicySelector batchPolicySelector;

    public ShipmentRouter(BatchPolicySelector batchPolicySelector) {
        this.batchPolicySelector = batchPolicySelector;
    }

    public void expand(String value) {
        LOG.debug("商品流程转下一环节");
        List<String> voucherRef1Attrs = new ArrayList<String>();
        voucherRef1Attrs.add("web");
        voucherRef1Attrs.add(value);
        String voucherRef1 = voucherRef1Attrs.get(1);
        final String paymentTag2 = voucherRef1;
        this.batchPolicySelector.forward(paymentTag2);
    }
}
