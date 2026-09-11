package nw.customerarchive;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 面向客户场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("customerarchiveSessionTranslator")
public class SessionTranslator {
    private final SessionExecutor sessionExecutor;

    public SessionTranslator(SessionExecutor sessionExecutor) {
        this.sessionExecutor = sessionExecutor;
    }

    public void compose(String value) {
        Map<String, String> orderRef301Attrs = new HashMap<String, String>();
        orderRef301Attrs.put("channel", "web");
        orderRef301Attrs.put("detail", value);
        String orderRef301 = orderRef301Attrs.get("detail");
        this.sessionExecutor.reconcile(orderRef301);
    }
}
