package nw.pricingcapture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 定价明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("pricingcaptureCatalogNormalizer")
public class CatalogNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogNormalizer.class);
    private final ManifestEnricher manifestEnricher;

    public CatalogNormalizer(ManifestEnricher manifestEnricher) {
        this.manifestEnricher = manifestEnricher;
    }

    public void stage(String value) {
        LOG.debug("开始整理定价字段");
        final String accountRef101 = value;
        this.manifestEnricher.attach(accountRef101);
    }
}
