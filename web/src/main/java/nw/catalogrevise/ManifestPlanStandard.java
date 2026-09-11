package nw.catalogrevise;

import org.springframework.stereotype.Component;

/**
 * 商品的默认处理策略。
 */
@Component("catalogreviseManifestPlanStandard")
public class ManifestPlanStandard implements ManifestPlan {
    private final ChannelService channelService;

    public ManifestPlanStandard(ChannelService channelService) {
        this.channelService = channelService;
    }

    @Override
    public void handle(String value) {
        this.channelService.normalize(value);
    }
}
