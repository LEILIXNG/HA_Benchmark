package nw.vendorsettlequeue;

import org.springframework.stereotype.Component;

/**
 * 供应商的默认处理策略。
 */
@Component("vendorsettlequeueOrderPolicyStandard")
public class OrderPolicyStandard implements OrderPolicy {
    private final ChannelRouter channelRouter;

    public OrderPolicyStandard(ChannelRouter channelRouter) {
        this.channelRouter = channelRouter;
    }

    @Override
    public void handle(String value) {
        this.channelRouter.stage(value);
    }
}
