package nw.pricingsettlequeue;

/**
 * 定价的默认处理策略。
 */
public final class CatalogRuleStandard implements CatalogRule {

    @Override
    public void handle(String value) {
        VoucherTranslator.submit(value);
    }
}
