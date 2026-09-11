package nw.orderintake;

import org.springframework.stereotype.Component;

/**
 * 订单明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("orderintakeLedgerBuilder")
public class LedgerBuilder {
    private final ManifestNormalizer manifestNormalizer;

    public LedgerBuilder(ManifestNormalizer manifestNormalizer) {
        this.manifestNormalizer = manifestNormalizer;
    }

    public void expand(String value) {
        String manifestKey1 = String.valueOf(value);
        this.manifestNormalizer.refine(manifestKey1);
    }
}
