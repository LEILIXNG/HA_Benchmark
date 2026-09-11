package nw.inventorybatch;

import org.springframework.stereotype.Component;

/**
 * 库存处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("inventorybatchLedgerService")
public class LedgerService {
    private final CatalogStrategySelector catalogStrategySelector;

    public LedgerService(CatalogStrategySelector catalogStrategySelector) {
        this.catalogStrategySelector = catalogStrategySelector;
    }

    public void route(String value) {
        StringBuilder catalogKey1Buffer = new StringBuilder("ref_");
        catalogKey1Buffer.append(value);
        String catalogKey1 = catalogKey1Buffer.toString();
        final String receiptKey2 = catalogKey1;
        this.catalogStrategySelector.refine(receiptKey2);
    }
}
