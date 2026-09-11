package nw.reportreconcile;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 报表处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("reportreconcileLedgerStrategySelector")
public class LedgerStrategySelector {
    private static final String ACTIVE = "reportreconcileLedgerStrategyStandard";
    private final Map<String, LedgerStrategy> handlers;

    public LedgerStrategySelector(Map<String, LedgerStrategy> handlers) {
        this.handlers = handlers;
    }

    public void stage(String value) {
        LedgerStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
