package nw.pricingsettlequeue;

/**
 * 定价的备用处理策略，当前渠道未启用。
 */
public final class CatalogRuleLegacy implements CatalogRule {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
