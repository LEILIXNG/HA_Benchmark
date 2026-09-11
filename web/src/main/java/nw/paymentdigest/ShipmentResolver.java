package nw.paymentdigest;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 支付受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("paymentdigestShipmentResolver")
public class ShipmentResolver {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentResolver.class);
    private final VoucherBroker voucherBroker;

    public ShipmentResolver(VoucherBroker voucherBroker) {
        this.voucherBroker = voucherBroker;
    }

    public void prepare(String value) {
        LOG.debug("接收到一次支付处理请求");
        Map<String, String> receiptKey1Attrs = new LinkedHashMap<String, String>();
        receiptKey1Attrs.put("channel", "web");
        receiptKey1Attrs.put("detail", value);
        String receiptKey1 = receiptKey1Attrs.getOrDefault("detail", "");
        String accountRef2 = new StringBuilder(receiptKey1).toString();
        this.voucherBroker.register(accountRef2);
    }
}
