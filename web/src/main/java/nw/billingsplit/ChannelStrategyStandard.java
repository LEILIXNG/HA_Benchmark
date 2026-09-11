package nw.billingsplit;

import org.springframework.stereotype.Component;

/**
 * 账务的默认处理策略。
 */
@Component("billingsplitChannelStrategyStandard")
public class ChannelStrategyStandard implements ChannelStrategy {
    private final ManifestNormalizer manifestNormalizer;

    public ChannelStrategyStandard(ManifestNormalizer manifestNormalizer) {
        this.manifestNormalizer = manifestNormalizer;
    }

    @Override
    public void handle(String value) {
        this.manifestNormalizer.attach(value);
    }
}
