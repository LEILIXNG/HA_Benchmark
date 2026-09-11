package nw.shippingdispatch;

import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 发运处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Repository("shippingdispatchBatchStrategySelector")
public class BatchStrategySelector {
    private static final String ACTIVE = "shippingdispatchBatchStrategyStandard";
    private final Map<String, BatchStrategy> handlers;

    public BatchStrategySelector(Map<String, BatchStrategy> handlers) {
        this.handlers = handlers;
    }

    public void normalize(String value) {
        BatchStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
