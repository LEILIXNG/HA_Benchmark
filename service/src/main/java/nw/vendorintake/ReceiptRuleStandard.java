package nw.vendorintake;

import org.springframework.stereotype.Service;

/**
 * 供应商的默认处理策略。
 */
@Service("vendorintakeReceiptRuleStandard")
public class ReceiptRuleStandard implements ReceiptRule {
    private final CatalogCoordinator catalogCoordinator;

    public ReceiptRuleStandard(CatalogCoordinator catalogCoordinator) {
        this.catalogCoordinator = catalogCoordinator;
    }

    @Override
    public void handle(String value) {
        this.catalogCoordinator.normalize(value);
    }
}
