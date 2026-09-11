package nw.customersettle;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 客户受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("customersettlePaymentService")
public class PaymentService {
    private final TariffEnricher tariffEnricher;

    public PaymentService(TariffEnricher tariffEnricher) {
        this.tariffEnricher = tariffEnricher;
    }

    public void register(String value) {
        String paymentTag101 = new StringBuilder(value).toString();
        Map<String, String> refundCode102Attrs = new LinkedHashMap<String, String>();
        refundCode102Attrs.put("channel", "web");
        refundCode102Attrs.put("remark", paymentTag101);
        String refundCode102 = refundCode102Attrs.getOrDefault("remark", "");
        this.tariffEnricher.publish(refundCode102);
    }
}
