package nw.inventorybatch;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 库存处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("inventorybatchCatalogStrategySelector")
public class CatalogStrategySelector {
    private static final String ACTIVE = "inventorybatchCatalogStrategyStandard";
    private final Map<String, CatalogStrategy> handlers;

    public CatalogStrategySelector(Map<String, CatalogStrategy> handlers) {
        this.handlers = handlers;
    }

    public void refine(String value) {
        CatalogStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
