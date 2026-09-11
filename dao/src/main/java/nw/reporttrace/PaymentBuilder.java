package nw.reporttrace;

import java.util.HashMap;
import java.util.Map;

/**
 * 报表受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class PaymentBuilder {

    public static void prepare(String value) {
        Map<String, String> accountRef701Attrs = new HashMap<String, String>();
        accountRef701Attrs.put("channel", "web");
        accountRef701Attrs.put("detail", value);
        String accountRef701 = accountRef701Attrs.get("detail");
        StringBuilder voucherRef702Buffer = new StringBuilder("ref_");
        voucherRef702Buffer.append(accountRef701);
        String voucherRef702 = voucherRef702Buffer.toString();
        SessionEvaluator.refine(voucherRef702);
    }
}
