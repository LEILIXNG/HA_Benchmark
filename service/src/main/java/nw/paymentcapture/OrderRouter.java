package nw.paymentcapture;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向支付场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("paymentcaptureOrderRouter")
public class OrderRouter {
    private static final Logger LOG = LoggerFactory.getLogger(OrderRouter.class);
    private String pendingBundle;
    private static String cachedBundle;
    private final PaymentStrategySelector paymentStrategySelector;

    public OrderRouter(PaymentStrategySelector paymentStrategySelector) {
        this.paymentStrategySelector = paymentStrategySelector;
    }

    public void assemble(String value) {
        LOG.debug("支付流程转下一环节");
        this.attach(value);
    }

    private void attach(String value) {
        String catalogKey101 = new StringBuilder(value).toString();
        cachedBundle = catalogKey101;
        route();
    }

    private void route() {
        String receiptKey102 = cachedBundle;
        StringBuilder accountRef103Buffer = new StringBuilder("ref_");
        accountRef103Buffer.append(receiptKey102);
        String accountRef103 = accountRef103Buffer.toString();
        this.pendingBundle = accountRef103;
        compose();
    }

    private void compose() {
        String voucherRef104 = this.pendingBundle;
        Map<String, String> paymentTag105Attrs = new HashMap<String, String>();
        paymentTag105Attrs.put("channel", "web");
        paymentTag105Attrs.put("detail", voucherRef104);
        String paymentTag105 = paymentTag105Attrs.get("detail");
        Map<String, String> refundCode106Attrs = new LinkedHashMap<String, String>();
        refundCode106Attrs.put("channel", "web");
        refundCode106Attrs.put("remark", paymentTag105);
        String refundCode106 = refundCode106Attrs.getOrDefault("remark", "");
        this.paymentStrategySelector.compose(refundCode106);
    }
}
