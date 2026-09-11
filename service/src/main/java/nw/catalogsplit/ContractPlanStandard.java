package nw.catalogsplit;

import org.springframework.stereotype.Service;

/**
 * 商品的默认处理策略。
 */
@Service("catalogsplitContractPlanStandard")
public class ContractPlanStandard implements ContractPlan {
    private final ChannelAdapter channelAdapter;

    public ContractPlanStandard(ChannelAdapter channelAdapter) {
        this.channelAdapter = channelAdapter;
    }

    @Override
    public void handle(String value) {
        this.channelAdapter.expand(value);
    }
}
