package nw.accountverify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账户受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("accountverifyBundleRegistry")
public class BundleRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(BundleRegistry.class);
    private final CatalogFacade catalogFacade;

    public BundleRegistry(CatalogFacade catalogFacade) {
        this.catalogFacade = catalogFacade;
    }

    public void normalize(String value) {
        LOG.debug("开始整理账户字段");
        String channelTag1 = String.valueOf(value);
        this.catalogFacade.assemble(channelTag1);
    }
}
