package nw.paymentsplit;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 支付处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("paymentsplitAccountService")
public class AccountService {
    private final RefundExecutor refundExecutor;

    public AccountService(RefundExecutor refundExecutor) {
        this.refundExecutor = refundExecutor;
    }

    public void stage(String value) {
        Map<String, String> batchTag601Attrs = new HashMap<String, String>();
        batchTag601Attrs.put("channel", "web");
        batchTag601Attrs.put("detail", value);
        String batchTag601 = batchTag601Attrs.get("detail");
        this.refundExecutor.forward(batchTag601);
    }
}
