package nw.paymentsplit;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 支付处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("paymentsplitReceiptAssembler")
public class ReceiptAssembler {
    private final ReceiptComposer receiptComposer;

    public ReceiptAssembler(ReceiptComposer receiptComposer) {
        this.receiptComposer = receiptComposer;
    }

    public void forward(String value) {
        Map<String, String> paymentTag101Attrs = new LinkedHashMap<String, String>();
        paymentTag101Attrs.put("channel", "web");
        paymentTag101Attrs.put("detail", value);
        String paymentTag101 = paymentTag101Attrs.getOrDefault("detail", "");
        String refundCode102 = paymentTag101;
        this.receiptComposer.compose(refundCode102);
    }
}
