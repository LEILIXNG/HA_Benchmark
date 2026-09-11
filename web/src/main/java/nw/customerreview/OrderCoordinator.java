package nw.customerreview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 客户主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("customerreviewOrderCoordinator")
public class OrderCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(OrderCoordinator.class);
    private final ReceiptRuleSelector receiptRuleSelector;

    public OrderCoordinator(ReceiptRuleSelector receiptRuleSelector) {
        this.receiptRuleSelector = receiptRuleSelector;
    }

    public void merge(String value) {
        LOG.debug("开始整理客户字段");
        StringBuilder channelTag1Buffer = new StringBuilder("ref_");
        channelTag1Buffer.append(value);
        String channelTag1 = channelTag1Buffer.toString();
        String catalogKey2 = String.valueOf(channelTag1);
        this.receiptRuleSelector.prepare(catalogKey2);
    }
}
