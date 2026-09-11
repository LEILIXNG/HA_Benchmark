package nw.fulfiladjust;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 履约处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("fulfiladjustRefundPolicySelector")
public class RefundPolicySelector {
    private static final String ACTIVE = "fulfiladjustRefundPolicyStandard";
    private final Map<String, RefundPolicy> handlers;

    public RefundPolicySelector(Map<String, RefundPolicy> handlers) {
        this.handlers = handlers;
    }

    public void forward(String value) {
        RefundPolicy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
