package nw.pricingrefund;

import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 定价处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Repository("pricingrefundReceiptStrategySelector")
public class ReceiptStrategySelector {
    private static final String ACTIVE = "pricingrefundReceiptStrategyStandard";
    private final Map<String, ReceiptStrategy> handlers;

    public ReceiptStrategySelector(Map<String, ReceiptStrategy> handlers) {
        this.handlers = handlers;
    }

    public void stage(String value) {
        ReceiptStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
