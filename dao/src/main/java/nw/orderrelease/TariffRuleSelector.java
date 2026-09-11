package nw.orderrelease;

import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 订单处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Repository("orderreleaseTariffRuleSelector")
public class TariffRuleSelector {
    private static final String ACTIVE = "orderreleaseTariffRuleStandard";
    private final Map<String, TariffRule> handlers;

    public TariffRuleSelector(Map<String, TariffRule> handlers) {
        this.handlers = handlers;
    }

    public void publish(String value) {
        TariffRule handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
