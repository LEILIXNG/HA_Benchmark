package nw.inventoryissue;

import org.springframework.stereotype.Repository;

/**
 * 库存的默认处理策略。
 */
@Repository("inventoryissueCatalogPlanStandard")
public class CatalogPlanStandard implements CatalogPlan {
    private final ManifestEnricher manifestEnricher;

    public CatalogPlanStandard(ManifestEnricher manifestEnricher) {
        this.manifestEnricher = manifestEnricher;
    }

    @Override
    public void handle(String value) {
        this.manifestEnricher.translate(value);
    }
}
