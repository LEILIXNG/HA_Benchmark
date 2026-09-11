package nw.catalogmanifest;

import org.springframework.stereotype.Service;

/**
 * 商品的备用处理策略，当前渠道未启用。
 */
@Service("catalogmanifestManifestStrategyLegacy")
public class ManifestStrategyLegacy implements ManifestStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
