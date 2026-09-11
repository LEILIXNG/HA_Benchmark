package nw.fulfilapprove;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 履约处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("fulfilapproveReceiptPlanSelector")
public class ReceiptPlanSelector {
    private static final String ACTIVE = "fulfilapproveReceiptPlanStandard";
    private final Map<String, ReceiptPlan> handlers;

    public ReceiptPlanSelector(Map<String, ReceiptPlan> handlers) {
        this.handlers = handlers;
    }

    public void compose(String value) {
        ReceiptPlan handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
