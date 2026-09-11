package nw.reportquote;

import org.springframework.stereotype.Service;

/**
 * 报表的默认处理策略。
 */
@Service("reportquoteQuotePlanStandard")
public class QuotePlanStandard implements QuotePlan {
    private final CatalogFacade catalogFacade;

    public QuotePlanStandard(CatalogFacade catalogFacade) {
        this.catalogFacade = catalogFacade;
    }

    @Override
    public void handle(String value) {
        this.catalogFacade.resolve(value);
    }
}
