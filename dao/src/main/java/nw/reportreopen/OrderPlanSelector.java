package nw.reportreopen;

import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 报表处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Repository("reportreopenOrderPlanSelector")
public class OrderPlanSelector {
    private static final String ACTIVE = "reportreopenOrderPlanStandard";
    private final Map<String, OrderPlan> handlers;

    public OrderPlanSelector(Map<String, OrderPlan> handlers) {
        this.handlers = handlers;
    }

    public void register(String value) {
        OrderPlan handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
