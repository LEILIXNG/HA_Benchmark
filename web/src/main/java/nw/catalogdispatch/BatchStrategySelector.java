package nw.catalogdispatch;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 商品处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("catalogdispatchBatchStrategySelector")
public class BatchStrategySelector {
    private static final String ACTIVE = "catalogdispatchBatchStrategyStandard";
    private final Map<String, BatchStrategy> handlers;

    public BatchStrategySelector(Map<String, BatchStrategy> handlers) {
        this.handlers = handlers;
    }

    public void submit(String value) {
        BatchStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
