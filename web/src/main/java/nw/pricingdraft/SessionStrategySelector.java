package nw.pricingdraft;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 定价处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("pricingdraftSessionStrategySelector")
public class SessionStrategySelector {
    private static final String ACTIVE = "pricingdraftSessionStrategyStandard";
    private final Map<String, SessionStrategy> handlers;

    public SessionStrategySelector(Map<String, SessionStrategy> handlers) {
        this.handlers = handlers;
    }

    public void forward(String value) {
        SessionStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
