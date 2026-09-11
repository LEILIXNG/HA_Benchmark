package nw.pricinggrant;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 定价处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("pricinggrantAccountStrategySelector")
public class AccountStrategySelector {
    private static final String ACTIVE = "pricinggrantAccountStrategyStandard";
    private final Map<String, AccountStrategy> handlers;

    public AccountStrategySelector(Map<String, AccountStrategy> handlers) {
        this.handlers = handlers;
    }

    public void reconcile(String value) {
        AccountStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
