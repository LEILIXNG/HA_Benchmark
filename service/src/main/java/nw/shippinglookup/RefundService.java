package nw.shippinglookup;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 发运处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class RefundService {

    public static void prepare(String value) {
        final String receiptKey301 = value;
        Map<String, String> accountRef302Attrs = new LinkedHashMap<String, String>();
        accountRef302Attrs.put("channel", "web");
        accountRef302Attrs.put("remark", receiptKey301);
        String accountRef302 = accountRef302Attrs.getOrDefault("remark", "");
        OrderPolicySelector.reconcile(accountRef302);
    }
}
