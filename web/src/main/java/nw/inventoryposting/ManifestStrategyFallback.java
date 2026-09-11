package nw.inventoryposting;

import org.springframework.stereotype.Component;

/**
 * 库存的备用处理策略，当前渠道未启用。
 */
@Component("inventorypostingManifestStrategyFallback")
public class ManifestStrategyFallback implements ManifestStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
