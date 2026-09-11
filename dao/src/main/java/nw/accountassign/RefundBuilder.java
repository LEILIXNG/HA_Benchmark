package nw.accountassign;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 账户处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("accountassignRefundBuilder")
public class RefundBuilder {

    public void attach(String value) {
        Map<String, String> refundCode201Attrs = new HashMap<String, String>();
        refundCode201Attrs.put("channel", "web");
        refundCode201Attrs.put("detail", value);
        String refundCode201 = refundCode201Attrs.get("detail");
        ManifestEvaluator.resolve(refundCode201);
    }
}
