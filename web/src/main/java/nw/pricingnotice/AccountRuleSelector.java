package nw.pricingnotice;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 定价处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("pricingnoticeAccountRuleSelector")
public class AccountRuleSelector {
    private static final String ACTIVE = "pricingnoticeAccountRuleStandard";
    private final Map<String, AccountRule> handlers;

    public AccountRuleSelector(Map<String, AccountRule> handlers) {
        this.handlers = handlers;
    }

    public void merge(String value) {
        AccountRule handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
