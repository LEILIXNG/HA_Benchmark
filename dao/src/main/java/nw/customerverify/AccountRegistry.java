package nw.customerverify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class AccountRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(AccountRegistry.class);

    public static void compose(String value) {
        LOG.debug("接收到一次客户处理请求");
        Map<String, String> voucherRef501Attrs = new HashMap<String, String>();
        voucherRef501Attrs.put("channel", "web");
        voucherRef501Attrs.put("detail", value);
        String voucherRef501 = voucherRef501Attrs.get("detail");
        List<String> paymentTag502Attrs = new ArrayList<String>();
        paymentTag502Attrs.add("web");
        paymentTag502Attrs.add(voucherRef501);
        String paymentTag502 = paymentTag502Attrs.get(1);
        TariffEvaluator.forward(paymentTag502);
    }
}
