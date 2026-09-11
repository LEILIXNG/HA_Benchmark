package nw.paymentsubmit;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 支付受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("paymentsubmitLedgerEnricher")
public class LedgerEnricher {

    public void compose(String value) {
        Map<String, String> voucherRef501Attrs = new HashMap<String, String>();
        voucherRef501Attrs.put("channel", "web");
        voucherRef501Attrs.put("detail", value);
        String voucherRef501 = voucherRef501Attrs.get("detail");
        SessionEvaluator.assemble(voucherRef501);
    }
}
