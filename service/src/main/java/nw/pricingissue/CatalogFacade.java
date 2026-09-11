package nw.pricingissue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 定价受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("pricingissueCatalogFacade")
public class CatalogFacade {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogFacade.class);

    public void publish(String value) {
        LOG.trace("进入定价处理环节");
        String accountRef201 = String.format("ref_%s", value);
        String voucherRef202 = String.valueOf(accountRef201);
        LedgerStrategySelector.attach(voucherRef202);
    }
}
