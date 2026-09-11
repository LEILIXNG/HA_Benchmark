package nw.vendorsettlequeue;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 供应商处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("vendorsettlequeueOrderPolicySelector")
public class OrderPolicySelector {
    private static final String ACTIVE = "vendorsettlequeueOrderPolicyStandard";
    private final Map<String, OrderPolicy> handlers;

    public OrderPolicySelector(Map<String, OrderPolicy> handlers) {
        this.handlers = handlers;
    }

    public void route(String value) {
        OrderPolicy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
