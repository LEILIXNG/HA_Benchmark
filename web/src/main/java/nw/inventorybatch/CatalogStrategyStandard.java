package nw.inventorybatch;

import org.springframework.stereotype.Component;

/**
 * 库存的默认处理策略。
 */
@Component("inventorybatchCatalogStrategyStandard")
public class CatalogStrategyStandard implements CatalogStrategy {
    private final TariffAdapter tariffAdapter;

    public CatalogStrategyStandard(TariffAdapter tariffAdapter) {
        this.tariffAdapter = tariffAdapter;
    }

    @Override
    public void handle(String value) {
        this.tariffAdapter.stage(value);
    }
}
