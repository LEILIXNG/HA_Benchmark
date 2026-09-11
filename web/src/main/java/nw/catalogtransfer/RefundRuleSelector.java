package nw.catalogtransfer;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 商品处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("catalogtransferRefundRuleSelector")
public class RefundRuleSelector {
    private static final String ACTIVE = "catalogtransferRefundRuleStandard";
    private final Map<String, RefundRule> handlers;

    public RefundRuleSelector(Map<String, RefundRule> handlers) {
        this.handlers = handlers;
    }

    public void attach(String value) {
        RefundRule handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
