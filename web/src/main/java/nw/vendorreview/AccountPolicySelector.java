package nw.vendorreview;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 供应商处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("vendorreviewAccountPolicySelector")
public class AccountPolicySelector {
    private static final String ACTIVE = "vendorreviewAccountPolicyStandard";
    private final Map<String, AccountPolicy> handlers;

    public AccountPolicySelector(Map<String, AccountPolicy> handlers) {
        this.handlers = handlers;
    }

    public void collect(String value) {
        AccountPolicy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
