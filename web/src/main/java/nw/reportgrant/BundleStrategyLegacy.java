package nw.reportgrant;

/**
 * 报表的备用处理策略，当前渠道未启用。
 */
public final class BundleStrategyLegacy implements BundleStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
