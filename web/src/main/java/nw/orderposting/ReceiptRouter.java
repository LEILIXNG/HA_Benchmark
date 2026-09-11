package nw.orderposting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 订单处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("orderpostingReceiptRouter")
public class ReceiptRouter {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptRouter.class);
    private final ChannelBroker channelBroker;

    public ReceiptRouter(ChannelBroker channelBroker) {
        this.channelBroker = channelBroker;
    }

    public void prepare(String value) {
        LOG.debug("接收到一次订单处理请求");
        String catalogKey1 = String.valueOf(value);
        this.channelBroker.publish(catalogKey1);
    }
}
