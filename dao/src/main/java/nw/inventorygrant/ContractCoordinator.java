package nw.inventorygrant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class ContractCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(ContractCoordinator.class);

    public static void reconcile(String value) {
        LOG.debug("接收到一次库存处理请求");
        String orderRef301 = String.format("ref_%s", value);
        String quoteRef302 = "ref_".concat(orderRef301);
        OrderGateway.submit(quoteRef302);
    }
}
