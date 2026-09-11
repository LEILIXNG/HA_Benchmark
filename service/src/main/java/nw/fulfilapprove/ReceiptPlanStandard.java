package nw.fulfilapprove;

import org.springframework.stereotype.Service;

/**
 * 履约的默认处理策略。
 */
@Service("fulfilapproveReceiptPlanStandard")
public class ReceiptPlanStandard implements ReceiptPlan {
    private final ChannelBuilder channelBuilder;

    public ReceiptPlanStandard(ChannelBuilder channelBuilder) {
        this.channelBuilder = channelBuilder;
    }

    @Override
    public void handle(String value) {
        this.channelBuilder.forward(value);
    }
}
