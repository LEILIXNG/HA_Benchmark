package nw.reportrefund;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 报表受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class InvoiceAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceAssembler.class);

    public static void route(String value) {
        LOG.debug("接收到一次报表处理请求");
        String receiptKey501 = String.format("ref_%s", value);
        Map<String, String> accountRef502Attrs = new LinkedHashMap<String, String>();
        accountRef502Attrs.put("channel", "web");
        accountRef502Attrs.put("remark", receiptKey501);
        String accountRef502 = accountRef502Attrs.getOrDefault("remark", "");
        PaymentPolicy.refine(accountRef502);
    }
}
