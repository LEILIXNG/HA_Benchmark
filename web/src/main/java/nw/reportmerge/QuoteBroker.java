package nw.reportmerge;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 报表处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class QuoteBroker {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteBroker.class);
    private String pendingContract;

    public static void route(String value) {
        LOG.debug("报表流程转下一环节");
        QuoteBroker self = new QuoteBroker();
        self.resolve(value);
    }

    private void resolve(String value) {
        final String receiptKey1 = value;
        this.pendingContract = receiptKey1;
        forward();
    }

    private void forward() {
        String accountRef2 = this.pendingContract;
        Map<String, String> voucherRef3Attrs = new LinkedHashMap<String, String>();
        voucherRef3Attrs.put("channel", "web");
        voucherRef3Attrs.put("note", accountRef2);
        String voucherRef3 = voucherRef3Attrs.getOrDefault("note", "");
        String paymentTag4 = String.valueOf(voucherRef3);
        ShipmentEnricher.resolve(paymentTag4);
    }
}
