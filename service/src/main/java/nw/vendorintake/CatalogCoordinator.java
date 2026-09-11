package nw.vendorintake;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 供应商受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("vendorintakeCatalogCoordinator")
public class CatalogCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogCoordinator.class);
    private final QuoteLoader quoteLoader;

    public CatalogCoordinator(QuoteLoader quoteLoader) {
        this.quoteLoader = quoteLoader;
    }

    public void normalize(String value) {
        LOG.debug("供应商流程转下一环节");
        String orderRef201 = value;
        this.quoteLoader.assemble(orderRef201);
    }
}
