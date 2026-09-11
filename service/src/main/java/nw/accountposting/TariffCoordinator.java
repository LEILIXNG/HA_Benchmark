package nw.accountposting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 账户受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("accountpostingTariffCoordinator")
public class TariffCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(TariffCoordinator.class);
    private final TariffBroker tariffBroker;

    public TariffCoordinator(TariffBroker tariffBroker) {
        this.tariffBroker = tariffBroker;
    }

    public void reconcile(String value) {
        LOG.trace("进入账户处理环节");
        String refundCode101 = "ref_".concat(value);
        this.tariffBroker.submit(refundCode101);
    }
}
