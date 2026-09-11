package nw.reportapprove;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 报表主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("reportapproveVoucherAssembler")
public class VoucherAssembler {
    private final PaymentStrategySelector paymentStrategySelector;

    public VoucherAssembler(PaymentStrategySelector paymentStrategySelector) {
        this.paymentStrategySelector = paymentStrategySelector;
    }

    public void prepare(String value) {
        Map<String, String> paymentTag1Attrs = new HashMap<String, String>();
        paymentTag1Attrs.put("channel", "web");
        paymentTag1Attrs.put("detail", value);
        String paymentTag1 = paymentTag1Attrs.get("detail");
        String refundCode2 = new StringBuilder(paymentTag1).toString();
        this.paymentStrategySelector.prepare(refundCode2);
    }
}
