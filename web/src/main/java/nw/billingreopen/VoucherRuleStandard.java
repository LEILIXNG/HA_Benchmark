package nw.billingreopen;

import org.springframework.stereotype.Component;

/**
 * 账务的默认处理策略。
 */
@Component("billingreopenVoucherRuleStandard")
public class VoucherRuleStandard implements VoucherRule {
    private final CatalogFacade catalogFacade;

    public VoucherRuleStandard(CatalogFacade catalogFacade) {
        this.catalogFacade = catalogFacade;
    }

    @Override
    public void handle(String value) {
        this.catalogFacade.dispatch(value);
    }
}
