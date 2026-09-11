package nw.reportissue;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 报表处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("reportissueQuotePlanSelector")
public class QuotePlanSelector {
    private static final String ACTIVE = "reportissueQuotePlanStandard";
    private final Map<String, QuotePlan> handlers;

    public QuotePlanSelector(Map<String, QuotePlan> handlers) {
        this.handlers = handlers;
    }

    public void merge(String value) {
        QuotePlan handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
