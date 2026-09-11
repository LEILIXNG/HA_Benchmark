package nw.billingrenewal;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 账务处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("billingrenewalLedgerStrategySelector")
public class LedgerStrategySelector {
    private static final String ACTIVE = "billingrenewalLedgerStrategyStandard";
    private final Map<String, LedgerStrategy> handlers;

    public LedgerStrategySelector(Map<String, LedgerStrategy> handlers) {
        this.handlers = handlers;
    }

    public void register(String value) {
        LedgerStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
