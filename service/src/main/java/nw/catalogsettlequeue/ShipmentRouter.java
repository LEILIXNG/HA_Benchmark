package nw.catalogsettlequeue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向商品场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("catalogsettlequeueShipmentRouter")
public class ShipmentRouter {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentRouter.class);
    private final ChannelRouter channelRouter;

    public ShipmentRouter(ChannelRouter channelRouter) {
        this.channelRouter = channelRouter;
    }

    public void assemble(String value) {
        LOG.debug("开始整理商品字段");
        String channelTag101 = value;
        String catalogKey102 = String.valueOf(channelTag101);
        this.channelRouter.attach(catalogKey102);
    }
}
