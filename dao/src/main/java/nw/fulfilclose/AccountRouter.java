package nw.fulfilclose;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 履约处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("fulfilcloseAccountRouter")
public class AccountRouter {
    private static final Logger LOG = LoggerFactory.getLogger(AccountRouter.class);
    private final CatalogEvaluator catalogEvaluator;

    public AccountRouter(CatalogEvaluator catalogEvaluator) {
        this.catalogEvaluator = catalogEvaluator;
    }

    public void submit(String value) {
        LOG.trace("进入履约处理环节");
        String paymentTag201 = "ref_" + value;
        Map<String, String> refundCode202Attrs = new HashMap<String, String>();
        refundCode202Attrs.put("channel", "web");
        refundCode202Attrs.put("remark", paymentTag201);
        String refundCode202 = refundCode202Attrs.get("remark");
        this.catalogEvaluator.prepare(refundCode202);
    }
}
