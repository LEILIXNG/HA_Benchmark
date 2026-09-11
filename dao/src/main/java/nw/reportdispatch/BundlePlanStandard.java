package nw.reportdispatch;

/**
 * 报表的默认处理策略。
 */
public final class BundlePlanStandard implements BundlePlan {

    @Override
    public void handle(String value) {
        OrderTranslator.submit(value);
    }
}
