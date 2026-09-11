package nw.inventoryposting;

import org.springframework.stereotype.Component;

/**
 * 库存的默认处理策略。
 */
@Component("inventorypostingManifestStrategyStandard")
public class ManifestStrategyStandard implements ManifestStrategy {
    private final ChannelResolver channelResolver;

    public ManifestStrategyStandard(ChannelResolver channelResolver) {
        this.channelResolver = channelResolver;
    }

    @Override
    public void handle(String value) {
        this.channelResolver.prepare(value);
    }
}
