package nw.reportquote;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 报表处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("reportquoteOrderStrategySelector")
public class OrderStrategySelector {
    private static final String ACTIVE = "reportquoteOrderStrategyStandard";
    private final Map<String, OrderStrategy> handlers;

    public OrderStrategySelector(Map<String, OrderStrategy> handlers) {
        this.handlers = handlers;
    }

    public void register(String value) {
        OrderStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
