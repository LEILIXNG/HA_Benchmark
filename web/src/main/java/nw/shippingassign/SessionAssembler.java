package nw.shippingassign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 发运主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("shippingassignSessionAssembler")
public class SessionAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(SessionAssembler.class);
    private final ShipmentRouter shipmentRouter;

    public SessionAssembler(ShipmentRouter shipmentRouter) {
        this.shipmentRouter = shipmentRouter;
    }

    public void compose(String value) {
        LOG.debug("发运流程转下一环节");
        String accountRef1 = new StringBuilder(value).toString();
        this.shipmentRouter.merge(accountRef1);
    }
}
