package nw.accountadjust;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 账户处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("accountadjustContractStrategySelector")
public class ContractStrategySelector {
    private static final String ACTIVE = "accountadjustContractStrategyStandard";
    private final Map<String, ContractStrategy> handlers;

    public ContractStrategySelector(Map<String, ContractStrategy> handlers) {
        this.handlers = handlers;
    }

    public void route(String value) {
        ContractStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
