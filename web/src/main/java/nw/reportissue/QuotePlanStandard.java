package nw.reportissue;

import org.springframework.stereotype.Component;

/**
 * 报表的默认处理策略。
 */
@Component("reportissueQuotePlanStandard")
public class QuotePlanStandard implements QuotePlan {
    private final SessionRouter sessionRouter;

    public QuotePlanStandard(SessionRouter sessionRouter) {
        this.sessionRouter = sessionRouter;
    }

    @Override
    public void handle(String value) {
        this.sessionRouter.prepare(value);
    }
}
