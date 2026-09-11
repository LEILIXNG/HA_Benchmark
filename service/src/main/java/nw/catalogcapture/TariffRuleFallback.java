package nw.catalogcapture;

import org.springframework.stereotype.Service;

/**
 * 商品的备用处理策略，当前渠道未启用。
 */
@Service("catalogcaptureTariffRuleFallback")
public class TariffRuleFallback implements TariffRule {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
