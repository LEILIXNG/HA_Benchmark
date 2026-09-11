package nw.accountsettlequeue;

import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 账户处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Repository("accountsettlequeueAccountStrategySelector")
public class AccountStrategySelector {
    private static final String ACTIVE = "accountsettlequeueAccountStrategyStandard";
    private final Map<String, AccountStrategy> handlers;

    public AccountStrategySelector(Map<String, AccountStrategy> handlers) {
        this.handlers = handlers;
    }

    public void enrich(String value) {
        AccountStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
