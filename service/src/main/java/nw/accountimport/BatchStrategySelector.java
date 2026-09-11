package nw.accountimport;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 账户处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("accountimportBatchStrategySelector")
public class BatchStrategySelector {
    private static final String ACTIVE = "accountimportBatchStrategyStandard";
    private final Map<String, BatchStrategy> handlers;

    public BatchStrategySelector(Map<String, BatchStrategy> handlers) {
        this.handlers = handlers;
    }

    public void dispatch(String value) {
        BatchStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
