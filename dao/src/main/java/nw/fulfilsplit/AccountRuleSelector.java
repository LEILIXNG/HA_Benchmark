package nw.fulfilsplit;

import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 履约处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Repository("fulfilsplitAccountRuleSelector")
public class AccountRuleSelector {
    private static final String ACTIVE = "fulfilsplitAccountRuleStandard";
    private final Map<String, AccountRule> handlers;

    public AccountRuleSelector(Map<String, AccountRule> handlers) {
        this.handlers = handlers;
    }

    public void forward(String value) {
        AccountRule handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
