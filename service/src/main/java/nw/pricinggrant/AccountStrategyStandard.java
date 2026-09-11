package nw.pricinggrant;

import org.springframework.stereotype.Service;

/**
 * 定价的默认处理策略。
 */
@Service("pricinggrantAccountStrategyStandard")
public class AccountStrategyStandard implements AccountStrategy {
    private final ChannelService channelService;

    public AccountStrategyStandard(ChannelService channelService) {
        this.channelService = channelService;
    }

    @Override
    public void handle(String value) {
        this.channelService.submit(value);
    }
}
