package nw.fulfiladjust;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 履约受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("fulfiladjustContractCoordinator")
public class ContractCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(ContractCoordinator.class);
    private final OrderTranslator orderTranslator;

    public ContractCoordinator(OrderTranslator orderTranslator) {
        this.orderTranslator = orderTranslator;
    }

    public void assemble(String value) {
        LOG.trace("进入履约处理环节");
        StringBuilder shipmentCode1Buffer = new StringBuilder("ref_");
        shipmentCode1Buffer.append(value);
        String shipmentCode1 = shipmentCode1Buffer.toString();
        this.orderTranslator.expand(shipmentCode1);
    }
}
