package nw.pricingreopen;

import org.springframework.stereotype.Repository;

/**
 * 定价受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("pricingreopenSessionTranslator")
public class SessionTranslator {
    private final ChannelStrategySelector channelStrategySelector;

    public SessionTranslator(ChannelStrategySelector channelStrategySelector) {
        this.channelStrategySelector = channelStrategySelector;
    }

    public void enrich(String value) {
        final String manifestKey301 = value;
        this.channelStrategySelector.publish(manifestKey301);
    }
}
