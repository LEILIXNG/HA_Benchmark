package nw.shippingtransfer;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 发运处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("shippingtransferAccountPlanSelector")
public class AccountPlanSelector {
    private static final String ACTIVE = "shippingtransferAccountPlanStandard";
    private final Map<String, AccountPlan> handlers;

    public AccountPlanSelector(Map<String, AccountPlan> handlers) {
        this.handlers = handlers;
    }

    public void attach(String value) {
        AccountPlan handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
