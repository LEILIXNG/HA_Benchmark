package nw.pricingreopen;

import org.springframework.stereotype.Repository;

/**
 * 定价的默认处理策略。
 */
@Repository("pricingreopenChannelStrategyStandard")
public class ChannelStrategyStandard implements ChannelStrategy {
    private final RefundRegistry refundRegistry;

    public ChannelStrategyStandard(RefundRegistry refundRegistry) {
        this.refundRegistry = refundRegistry;
    }

    @Override
    public void handle(String value) {
        this.refundRegistry.submit(value);
    }
}
