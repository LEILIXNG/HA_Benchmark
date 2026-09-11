package nw.vendorbatch;

import org.springframework.stereotype.Service;

/**
 * 供应商的默认处理策略。
 */
@Service("vendorbatchChannelRuleStandard")
public class ChannelRuleStandard implements ChannelRule {
    private final ReceiptFacade receiptFacade;

    public ChannelRuleStandard(ReceiptFacade receiptFacade) {
        this.receiptFacade = receiptFacade;
    }

    @Override
    public void handle(String value) {
        this.receiptFacade.assemble(value);
    }
}
