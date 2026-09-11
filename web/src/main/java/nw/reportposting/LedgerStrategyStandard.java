package nw.reportposting;

import org.springframework.stereotype.Component;

/**
 * 报表的默认处理策略。
 */
@Component("reportpostingLedgerStrategyStandard")
public class LedgerStrategyStandard implements LedgerStrategy {
    private final ChannelFacade channelFacade;

    public LedgerStrategyStandard(ChannelFacade channelFacade) {
        this.channelFacade = channelFacade;
    }

    @Override
    public void handle(String value) {
        this.channelFacade.reconcile(value);
    }
}
